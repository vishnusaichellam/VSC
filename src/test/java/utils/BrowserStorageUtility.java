package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BrowserStorageUtility {

    private JavascriptExecutor js;

    public BrowserStorageUtility(WebDriver driver) {
        js = (JavascriptExecutor) driver;
    }

    // =========================
    // Local Storage
    // =========================

    public void setLocalStorage(String key, String value) {

        js.executeScript(
                "localStorage.setItem(arguments[0], arguments[1]);",
                key,
                value
        );
    }

    public String getLocalStorage(String key) {

        return (String) js.executeScript(
                "return localStorage.getItem(arguments[0]);",
                key
        );
    }

    public void removeLocalStorage(String key) {

        js.executeScript(
                "localStorage.removeItem(arguments[0]);",
                key
        );
    }

    public void clearLocalStorage() {

        js.executeScript(
                "localStorage.clear();"
        );
    }

    // =========================
    // Session Storage
    // =========================

    public void setSessionStorage(String key, String value) {

        js.executeScript(
                "sessionStorage.setItem(arguments[0], arguments[1]);",
                key,
                value
        );
    }

    public String getSessionStorage(String key) {

        return (String) js.executeScript(
                "return sessionStorage.getItem(arguments[0]);",
                key
        );
    }

    public void removeSessionStorage(String key) {

        js.executeScript(
                "sessionStorage.removeItem(arguments[0]);",
                key
        );
    }

    public void clearSessionStorage() {

        js.executeScript(
                "sessionStorage.clear();"
        );
    }
}