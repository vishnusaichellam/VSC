package tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookieTest {

    @Test
    public void cookieDeleteTest() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/");

            // Create cookies
            Cookie usernameCookie =
                    new Cookie("username", "Vishnu");

            Cookie roleCookie =
                    new Cookie("role", "SDET");

            // Add cookies
            driver.manage().addCookie(usernameCookie);
            driver.manage().addCookie(roleCookie);

            // Verify username cookie exists
            Cookie username =
                    driver.manage().getCookieNamed("username");

            Assert.assertNotNull(username);

            System.out.println(
                    "Before deletion: "
                            + username.getName()
                            + " = "
                            + username.getValue()
            );

            // Delete one specific cookie
            driver.manage().deleteCookieNamed("username");

            // Verify username cookie was deleted
            Cookie deletedUsername =
                    driver.manage().getCookieNamed("username");

            Assert.assertNull(deletedUsername);

            System.out.println(
                    "Username cookie deleted successfully!"
            );

            // Verify role cookie still exists
            Cookie role =
                    driver.manage().getCookieNamed("role");

            Assert.assertNotNull(role);

            System.out.println(
                    "Role cookie still exists: "
                            + role.getValue()
            );

            // Delete all cookies
            driver.manage().deleteAllCookies();

            // Verify all cookies are deleted
            Assert.assertEquals(
                    driver.manage().getCookies().size(),
                    0
            );

            System.out.println(
                    "All cookies deleted successfully!"
            );

        } finally {

            driver.quit();
        }
    }
}