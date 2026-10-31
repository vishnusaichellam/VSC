package tests;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StorageTabTest {

    @Test
    public void storageTabTest() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/");

            JavascriptExecutor js =
                    (JavascriptExecutor) driver;

            // Store data in parent tab
            js.executeScript(
                    "localStorage.setItem('localUser', 'Vishnu');"
            );

            js.executeScript(
                    "sessionStorage.setItem('sessionUser', 'SDET');"
            );

            String parentWindow =
                    driver.getWindowHandle();

            // Open a new tab
            js.executeScript(
                    "window.open('https://the-internet.herokuapp.com/', '_blank');"
            );

            Set<String> windows =
                    driver.getWindowHandles();

            // Switch to new tab
            for (String window : windows) {

                if (!window.equals(parentWindow)) {

                    driver.switchTo().window(window);

                    break;
                }
            }

            // Read Local Storage
            String localUser =
                    (String) js.executeScript(
                            "return localStorage.getItem('localUser');"
                    );

            // Read Session Storage
            String sessionUser =
                    (String) js.executeScript(
                            "return sessionStorage.getItem('sessionUser');"
                    );

            System.out.println(
                    "Local Storage in new tab: "
                            + localUser
            );

            System.out.println(
                    "Session Storage in new tab: "
                            + sessionUser
            );

            Assert.assertEquals(
                    localUser,
                    "Vishnu"
            );

            Assert.assertEquals(
                    sessionUser,
                    "SDET"
            );

            System.out.println(
                    "Storage behavior in new tab verified!"
            );

        } finally {

            driver.quit();
        }
    }
}