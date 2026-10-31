package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SessionStorageRemoveClearTest {

    @Test
    public void removeAndClearSessionStorage() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/");

            JavascriptExecutor js =
                    (JavascriptExecutor) driver;

            // Store two values
            js.executeScript(
                    "sessionStorage.setItem('username', 'Vishnu');"
            );

            js.executeScript(
                    "sessionStorage.setItem('role', 'SDET');"
            );

            // Verify username exists
            String username =
                    (String) js.executeScript(
                            "return sessionStorage.getItem('username');"
                    );

            System.out.println(
                    "Before removal: username = " + username
            );

            Assert.assertEquals(username, "Vishnu");

            // Remove username
            js.executeScript(
                    "sessionStorage.removeItem('username');"
            );

            // Verify username is removed
            String removedUsername =
                    (String) js.executeScript(
                            "return sessionStorage.getItem('username');"
                    );

            System.out.println(
                    "After removal: username = " + removedUsername
            );

            Assert.assertNull(removedUsername);

            // Verify role still exists
            String role =
                    (String) js.executeScript(
                            "return sessionStorage.getItem('role');"
                    );

            System.out.println(
                    "Role still exists: " + role
            );

            Assert.assertEquals(role, "SDET");

            // Clear Session Storage
            js.executeScript(
                    "sessionStorage.clear();"
            );

            // Verify storage is empty
            Long storageLength =
                    (Long) js.executeScript(
                            "return sessionStorage.length;"
                    );

            System.out.println(
                    "Session Storage items after clear: "
                            + storageLength
            );

            Assert.assertEquals(
                    storageLength.longValue(), 0L
            );

            System.out.println(
                    "Session Storage remove and clear test passed!"
            );

        } finally {

            driver.quit();
        }
    }
}