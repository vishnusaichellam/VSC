package tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class CookieUtility {

    private WebDriver driver;

    public CookieUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void addCookie(String name, String value) {

        Cookie cookie = new Cookie(name, value);

        driver.manage().addCookie(cookie);
    }

    public Cookie getCookie(String name) {

        return driver.manage().getCookieNamed(name);
    }

    public Set<Cookie> getAllCookies() {

        return driver.manage().getCookies();
    }

    public void deleteCookie(String name) {

        driver.manage().deleteCookieNamed(name);
    }

    public void deleteAllCookies() {

        driver.manage().deleteAllCookies();
    }
}