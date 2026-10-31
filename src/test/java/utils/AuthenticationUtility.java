package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class AuthenticationUtility {

    private WebDriver driver;

    public AuthenticationUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void addSessionCookie(String name, String value) {

        Cookie sessionCookie =
                new Cookie.Builder(name, value)
                        .path("/")
                        .isHttpOnly(true)
                        .isSecure(true)
                        .build();

        driver.manage().addCookie(sessionCookie);
    }

    public boolean isSessionCookiePresent(String name) {

        Cookie cookie =
                driver.manage().getCookieNamed(name);

        return cookie != null;
    }

    public String getSessionCookieValue(String name) {

        Cookie cookie =
                driver.manage().getCookieNamed(name);

        if (cookie == null) {
            return null;
        }

        return cookie.getValue();
    }

    public void clearAuthentication() {

        driver.manage().deleteAllCookies();
    }
}