package com.cellarhq.endpoints.auth

import com.cellarhq.Messages
import com.cellarhq.auth.Role
import com.cellarhq.domain.jooq.Cellar
import com.cellarhq.domain.jooq.OAuthAccount
import com.cellarhq.services.JooqCellarService
import com.cellarhq.services.JooqAccountService
import com.cellarhq.util.LogUtil
import com.google.inject.Inject
import groovy.util.logging.Slf4j
import org.pac4j.oauth.profile.twitter.TwitterProfile
import ratpack.groovy.handling.GroovyContext
import ratpack.groovy.handling.GroovyHandler
import ratpack.pac4j.internal.SessionConstants
import ratpack.session.store.SessionStorage

import java.sql.Timestamp
import java.time.LocalDateTime

/**
 * Endpoint for the Twitter login.
 *
 * This endpoint requires authentication, so the idea is that we can just hit it with a request and the Twitter handler
 * will be capable of auto-authenticating and return back to this endpoint to complete the login (and/or registration)
 * process.
 *
 * @todo Need to handle user case of a Twitter user logging in the first time and their Cellar.screenName is already
 *       taken...
 */
@Slf4j
class TwitterLoginEndpoint extends GroovyHandler {

    private final JooqAccountService accountService
    private final JooqCellarService cellarService

    @Inject
    TwitterLoginEndpoint(JooqAccountService accountService, JooqCellarService cellarService) {
        this.accountService = accountService
        this.cellarService = cellarService
    }

    @SuppressWarnings('NestedBlockDepth')
    @Override
    protected void handle(GroovyContext context) {
        context.with {
            byMethod {
                get {
                    TwitterProfile twitterProfile = request.get(TwitterProfile)

                    blocking {
                        OAuthAccount account = accountService.findByCredentials(twitterProfile.username)
                        if (account) {
                            cellarService.updateLoginStats(account.cellar, twitterProfile)
                        } else {
                            Cellar cellar = new Cellar().with { Cellar self ->
                                screenName = twitterProfile.username
                                displayName = twitterProfile.displayName
                                location = twitterProfile.location
                                website = twitterProfile.profileUrl
                                bio = twitterProfile.description
                                lastLogin = Timestamp.valueOf(LocalDateTime.now())

                                // TODO Photo

                                addRole(Role.MEMBER)
                                return self
                            }
                            account = new OAuthAccount(
                                    username: twitterProfile.username,
                                    cellar: cellar
                            )
                            accountService.create(account)
                        }

                        account
                    } onError { Throwable e ->
                        log.error(LogUtil.toLog('TwitterLoginEndpoint'), e)
                        redirect(500, "/logout?error=${Messages.UNEXPECTED_SERVER_ERROR}")
                    } then { OAuthAccount oAuthAccount ->
                        twitterProfile.id = oAuthAccount.cellar.id
                        request.get(SessionStorage).put(SessionConstants.USER_PROFILE, twitterProfile)

                        redirect('/yourcellar')
                    }
                }
            }
        }
    }
}
