package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SessionStorageTest {

    @Test
    public void sessionStorageTest() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/");

            JavascriptExecutor js =
                    (JavascriptExecutor) driver;

            // Store values
            js.executeScript(
                    "sessionStorage.setItem('username', 'Vishnu');"
            );

            js.executeScript(
                    "sessionStorage.setItem('role', 'SDET');"
            );

            // Retrieve username
            String username =
                    (String) js.executeScript(
                            "return sessionStorage.getItem('username');"
                    );

            // Retrieve role
            String role =
                    (String) js.executeScript(
                            "return sessionStorage.getItem('role');"
                    );

            System.out.println("Username: " + username);
            System.out.println("Role: " + role);

            // Verify values
            Assert.assertEquals(username, "Vishnu");
            Assert.assertEquals(role, "SDET");

            // Verify storage length
            Long storageLength =
                    (Long) js.executeScript(
                            "return sessionStorage.length;"
                    );

            System.out.println(
                    "Session Storage items: " + storageLength
            );

            Assert.assertEquals(storageLength.longValue(), 2L);

            System.out.println(
                    "Session Storage test passed!"
            );

        } finally {

            driver.quit();
        }
    }
}