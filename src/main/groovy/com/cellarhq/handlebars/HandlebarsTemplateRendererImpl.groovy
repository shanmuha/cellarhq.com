package com.cellarhq.handlebars

import com.cellarhq.session.FlashMessage
import com.cellarhq.util.LogUtil
import com.cellarhq.util.SessionUtil
import com.github.jknack.handlebars.Handlebars
import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.pac4j.core.profile.CommonProfile
import ratpack.handlebars.Template
import ratpack.handlebars.internal.HandlebarsTemplateRenderer
import ratpack.handling.Context
import ratpack.http.Request
import ratpack.session.store.SessionStorage

/**
 * Adds default variables for handlebar templates into the model.
 */
@Slf4j
@CompileStatic
class HandlebarsTemplateRendererImpl extends HandlebarsTemplateRenderer {

    private final static String DEFAULT_PAGE_ID = 'unknown'
    private final static String DEFAULT_TITLE = 'CellarHQ'

    private final static String MODEL_PAGE_ID = 'pageId'
    private final static String MODEL_TITLE = 'title'
    private final static String MODEL_LOGGED_IN = 'loggedIn'

    @Inject
    HandlebarsTemplateRendererImpl(Handlebars handlebars) {
        super(handlebars)
    }

    @Override
    void render(Context context, Template template) {
        Map<String, ?> model = (Map<String, ?>) template.model
        if (model == null) {
            model = [:]
        }

        if (!model.containsKey(MODEL_PAGE_ID)) {
            logMissingVariable(MODEL_PAGE_ID, context.request.uri)
            model[MODEL_PAGE_ID] = DEFAULT_PAGE_ID
        }

        if (!model.containsKey(MODEL_TITLE)) {
            logMissingVariable(MODEL_TITLE, context.request.uri)
            model[MODEL_TITLE] = DEFAULT_TITLE
        }

        model[MODEL_LOGGED_IN] = SessionUtil.isLoggedIn(context.request.maybeGet(CommonProfile))
        applyFlashMessages(context.request, model)

        super.render(context, template)
    }

    static void applyFlashMessages(Request request, Map<String, ?> model) {
        SessionStorage session = request.get(SessionStorage)

        if (request.queryParams.error) {
            FlashMessage msg = FlashMessage.error(request.queryParams.error)
            session.put(msg.type.name, msg)
        }

        FlashMessage.Type.values().each { FlashMessage.Type type ->
            String name = type.name
            String messagesName = type.messagesName

            if (session.containsKey(name)) {
                FlashMessage flashMessage = (FlashMessage) session.remove(name)
                model[name] = flashMessage.message
                model[messagesName] = flashMessage.embeddedMessages
            }
        }
    }

    private static void logMissingVariable(String variableName, String uri) {
        log.warn(LogUtil.toLog('HandlebarsTemplateRendererImpl', [
                uri: uri,
                msg: "Missing '${variableName}' model variable"
        ]))
    }
}