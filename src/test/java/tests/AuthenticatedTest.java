package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticatedTest extends BaseTest {

    @Test
    public void verifyAuthenticatedState() {

        // Cookie requires a web domain
        driver.get("https://the-internet.herokuapp.com/");

        // Establish simulated authenticated state
        authentication.addSessionCookie(
                "sessionId",
                "ABC123"
        );

        // Verify cookie exists
        Assert.assertTrue(
                authentication.isSessionCookiePresent("sessionId")
        );

        System.out.println(
                "Authenticated session established!"
        );

        // Verify session value
        String sessionId =
                authentication.getSessionCookieValue(
                        "sessionId"
                );

        System.out.println(
                "Session ID: " + sessionId
        );

        Assert.assertEquals(
                sessionId,
                "ABC123"
        );
    }
}