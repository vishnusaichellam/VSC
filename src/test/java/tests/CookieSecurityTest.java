package tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookieSecurityTest {

    @Test
    public void cookieSecurityTest() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/");

            Cookie securityCookie =
                    new Cookie.Builder("sessionId", "ABC123")
                            .path("/")
                            .isHttpOnly(true)
                            .isSecure(true)
                            .build();

            driver.manage().addCookie(securityCookie);

            Cookie cookie =
                    driver.manage().getCookieNamed("sessionId");

            Assert.assertNotNull(cookie);

            System.out.println("Cookie name: " + cookie.getName());
            System.out.println("Cookie value: " + cookie.getValue());
            System.out.println("Cookie path: " + cookie.getPath());
            System.out.println("HttpOnly: " + cookie.isHttpOnly());
            System.out.println("Secure: " + cookie.isSecure());

            Assert.assertEquals(cookie.getName(), "sessionId");
            Assert.assertEquals(cookie.getValue(), "ABC123");
            Assert.assertEquals(cookie.getPath(), "/");
            Assert.assertTrue(cookie.isHttpOnly());
            Assert.assertTrue(cookie.isSecure());

            System.out.println("Cookie security properties verified!");

        } finally {

            driver.quit();
        }
    }
}