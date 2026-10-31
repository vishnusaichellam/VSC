package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AuthenticationUtility;

public class AuthenticationUtilityTest {

    @Test
    public void authenticationUtilityTest() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/");

            AuthenticationUtility auth =
                    new AuthenticationUtility(driver);

            // Establish simulated authenticated state
            auth.addSessionCookie(
                    "sessionId",
                    "ABC123"
            );

            // Verify cookie exists
            Assert.assertTrue(
                    auth.isSessionCookiePresent("sessionId")
            );

            // Verify value
            String value =
                    auth.getSessionCookieValue("sessionId");

            System.out.println(
                    "Session ID: " + value
            );

            Assert.assertEquals(
                    value,
                    "ABC123"
            );

            // Refresh application
            driver.navigate().refresh();

            // Verify session cookie still exists
            Assert.assertTrue(
                    auth.isSessionCookiePresent("sessionId")
            );

            System.out.println(
                    "Authenticated state preserved after refresh!"
            );

            // Clear authentication
            auth.clearAuthentication();

            Assert.assertFalse(
                    auth.isSessionCookiePresent("sessionId")
            );

            System.out.println(
                    "Authentication cleared successfully!"
            );

        } finally {

            driver.quit();
        }
    }
}