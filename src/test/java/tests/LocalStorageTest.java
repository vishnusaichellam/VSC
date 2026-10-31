package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocalStorageTest {

    @Test
    public void localStorageTest() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/");

            JavascriptExecutor js =
                    (JavascriptExecutor) driver;

            // Store data
            js.executeScript(
                    "localStorage.setItem('username', 'Vishnu');"
            );

            js.executeScript(
                    "localStorage.setItem('role', 'SDET');"
            );

            // Retrieve username
            String username =
                    (String) js.executeScript(
                            "return localStorage.getItem('username');"
                    );

            // Retrieve role
            String role =
                    (String) js.executeScript(
                            "return localStorage.getItem('role');"
                    );

            System.out.println(
                    "Username: " + username
            );

            System.out.println(
                    "Role: " + role
            );

            // Verify
            Assert.assertEquals(
                    username,
                    "Vishnu"
            );

            Assert.assertEquals(
                    role,
                    "SDET"
            );

            System.out.println(
                    "Local Storage test passed!"
            );

        } finally {

            driver.quit();
        }
    }
}