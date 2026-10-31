package tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SessionCookieTest {

    @Test
    public void sessionCookieTest() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/");

            // Create a simulated session cookie
            Cookie sessionCookie =
                    new Cookie.Builder("sessionId", "ABC123")
                            .path("/")
                            .isHttpOnly(true)
                            .isSecure(true)
                            .build();

            // Add cookie to browser
            driver.manage().addCookie(sessionCookie);

            // Retrieve cookie
            Cookie retrievedCookie =
                    driver.manage().getCookieNamed("sessionId");

            Assert.assertNotNull(retrievedCookie);

            System.out.println(
                    "Session cookie name: "
                            + retrievedCookie.getName()
            );

            System.out.println(
                    "Session cookie value: "
                            + retrievedCookie.getValue()
            );

            System.out.println(
                    "HttpOnly: "
                            + retrievedCookie.isHttpOnly()
            );

            System.out.println(
                    "Secure: "
                            + retrievedCookie.isSecure()
            );

            // Refresh page so browser continues with the cookie
            driver.navigate().refresh();

            Cookie afterRefresh =
                    driver.manage().getCookieNamed("sessionId");

            Assert.assertNotNull(afterRefresh);

            Assert.assertEquals(
                    afterRefresh.getValue(),
                    "ABC123"
            );

            System.out.println(
                    "Session cookie still exists after refresh!"
            );

        } finally {

            driver.quit();
        }
    }
}