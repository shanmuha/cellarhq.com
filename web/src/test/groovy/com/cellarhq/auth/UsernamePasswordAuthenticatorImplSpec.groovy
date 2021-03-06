package com.cellarhq.auth

import com.cellarhq.auth.services.AccountService
import com.cellarhq.domain.EmailAccount
import org.pac4j.core.credentials.Credentials
import org.pac4j.core.exception.CredentialsException
import org.pac4j.http.credentials.UsernamePasswordCredentials
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDateTime

class UsernamePasswordAuthenticatorImplSpec extends Specification {

  @Unroll("failure delay is '#expectedDelay' seconds after '#attempts' attempts")
  def 'login failure delay increases incrementally after first failure'() {
    given:
    UsernamePasswordAuthenticatorImpl authenticator = new UsernamePasswordAuthenticatorImpl(
      Mock(AccountService),
      Mock(PasswordService)
    )
    LocalDateTime threeMinutesAgo = LocalDateTime.now().minusMinutes(3)

    when:
    int result = authenticator.calculateDelay(threeMinutesAgo, attempts)

    then:
    noExceptionThrown()
    assert result == expectedDelay

    where:
    attempts || expectedDelay
    0        || 0
    1        || 0
    2        || 2
    3        || 4
    4        || 6
    10       || UsernamePasswordAuthenticatorImpl.MAX_DELAY_SECONDS
  }

  def 'an unclaimed account throws a credential exception'() {
    given:
    PasswordService passwordService = Stub() {
      checkPassword(_, _) >> {
        throw new UnclaimedAccountException()
      }
    }
    AccountService accountService = Stub() {
      findByEmail(_) >> {
        return new EmailAccount()
      }
    }

    and:
    UsernamePasswordAuthenticatorImpl authenticator = new UsernamePasswordAuthenticatorImpl(
      accountService,
      passwordService
    )

    and:
    Credentials credentials = new UsernamePasswordCredentials('foo', PasswordService.UNCLAIMED_MARKER, 'FormClient')

    when:
    authenticator.validate(credentials)

    then:
    Throwable t = thrown(CredentialsException)
    assert t.message == UnclaimedAccountException.UNCLAIMED_MESSAGE
  }

  def 'an account with a too-strong password will be rehashed'() {
    given:
    PasswordService passwordService = Stub() {
      checkPassword(_, _) >> {
        return true
      }
      shouldRehashPassword(_) >> { String hash ->
        new PasswordService().shouldRehashPassword(hash)
      }
    }
    AccountService accountService = Mock() {
      findByEmail(_) >> {
        return new EmailAccount(
          password: '$2a$160$WBCR3zsCnH20tDjl'
        )
      }
    }

    and:
    UsernamePasswordAuthenticatorImpl authenticator = new UsernamePasswordAuthenticatorImpl(
      accountService,
      passwordService
    )

    and:
    Credentials credentials = new UsernamePasswordCredentials('foo', 'foo', 'FormClient')

    when:
    authenticator.validate(credentials)

    then:
    noExceptionThrown()
    1 * accountService.changePassword(_, _)
  }
}
