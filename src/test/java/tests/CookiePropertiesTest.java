package tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookiePropertiesTest {

    @Test
    public void cookiePropertiesTest() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/");

            Cookie cookie =
                    new Cookie.Builder(
                            "sessionId",
                            "ABC123"
                    )
                            .path("/")
                            .isSecure(false)
                            .isHttpOnly(true)
                            .build();

            driver.manage().addCookie(cookie);

            Cookie retrievedCookie =
                    driver.manage().getCookieNamed("sessionId");

            System.out.println(
                    "Name: "
                            + retrievedCookie.getName()
            );

            System.out.println(
                    "Value: "
                            + retrievedCookie.getValue()
            );

            System.out.println(
                    "Path: "
                            + retrievedCookie.getPath()
            );

            System.out.println(
                    "Secure: "
                            + retrievedCookie.isSecure()
            );

            System.out.println(
                    "HttpOnly: "
                            + retrievedCookie.isHttpOnly()
            );

            Assert.assertNotNull(retrievedCookie);

            Assert.assertEquals(
                    retrievedCookie.getValue(),
                    "ABC123"
            );

            Assert.assertTrue(
                    retrievedCookie.isHttpOnly()
            );

            System.out.println(
                    "Cookie properties verified!"
            );

        } finally {

            driver.quit();
        }
    }
}