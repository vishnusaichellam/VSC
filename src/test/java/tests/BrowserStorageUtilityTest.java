package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserStorageUtility;

public class BrowserStorageUtilityTest {

    @Test
    public void browserStorageUtilityTest() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/");

            BrowserStorageUtility storage =
                    new BrowserStorageUtility(driver);

            // =========================
            // Local Storage
            // =========================

            storage.setLocalStorage(
                    "username",
                    "Vishnu"
            );

            storage.setLocalStorage(
                    "role",
                    "SDET"
            );

            String localUsername =
                    storage.getLocalStorage("username");

            String localRole =
                    storage.getLocalStorage("role");

            System.out.println(
                    "Local Username: " + localUsername
            );

            System.out.println(
                    "Local Role: " + localRole
            );

            Assert.assertEquals(
                    localUsername,
                    "Vishnu"
            );

            Assert.assertEquals(
                    localRole,
                    "SDET"
            );

            // Remove one Local Storage item
            storage.removeLocalStorage("username");

            Assert.assertNull(
                    storage.getLocalStorage("username")
            );

            Assert.assertEquals(
                    storage.getLocalStorage("role"),
                    "SDET"
            );

            System.out.println(
                    "Local Storage operations passed!"
            );

            // Clear Local Storage
            storage.clearLocalStorage();

            Assert.assertNull(
                    storage.getLocalStorage("role")
            );

            // =========================
            // Session Storage
            // =========================

            storage.setSessionStorage(
                    "username",
                    "Vishnu"
            );

            storage.setSessionStorage(
                    "role",
                    "SDET"
            );

            String sessionUsername =
                    storage.getSessionStorage("username");

            String sessionRole =
                    storage.getSessionStorage("role");

            System.out.println(
                    "Session Username: " + sessionUsername
            );

            System.out.println(
                    "Session Role: " + sessionRole
            );

            Assert.assertEquals(
                    sessionUsername,
                    "Vishnu"
            );

            Assert.assertEquals(
                    sessionRole,
                    "SDET"
            );

            // Remove one Session Storage item
            storage.removeSessionStorage("username");

            Assert.assertNull(
                    storage.getSessionStorage("username")
            );

            Assert.assertEquals(
                    storage.getSessionStorage("role"),
                    "SDET"
            );

            System.out.println(
                    "Session Storage operations passed!"
            );

            // Clear Session Storage
            storage.clearSessionStorage();

            Assert.assertNull(
                    storage.getSessionStorage("role")
            );

            System.out.println(
                    "Browser Storage Utility test passed!"
            );

        } finally {

            driver.quit();
        }
    }
}