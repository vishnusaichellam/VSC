package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationStateTest extends BaseTest {

    @Test
    public void verifyAuthenticatedAndUnauthenticatedState() {

        // Navigate to a web origin
        driver.get("https://the-internet.herokuapp.com/");

        // -----------------------------
        // 1. Establish authenticated state
        // -----------------------------

        authentication.addSessionCookie(
                "sessionId",
                "ABC123"
        );

        Assert.assertTrue(
                authentication.isSessionCookiePresent("sessionId")
        );

        System.out.println(
                "Authenticated state: Session exists"
        );

        // -----------------------------
        // 2. Clear authentication
        // -----------------------------

        authentication.clearAuthentication();

        // -----------------------------
        // 3. Verify unauthenticated state
        // -----------------------------

        Assert.assertFalse(
                authentication.isSessionCookiePresent("sessionId")
        );

        System.out.println(
                "Unauthenticated state: Session cleared"
        );
    }
}