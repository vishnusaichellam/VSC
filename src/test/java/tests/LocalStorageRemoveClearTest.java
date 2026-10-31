package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocalStorageRemoveClearTest {

    @Test
    public void removeAndClearLocalStorage() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/");

            JavascriptExecutor js =
                    (JavascriptExecutor) driver;

            // Store two values
            js.executeScript(
                    "localStorage.setItem('username', 'Vishnu');"
            );

            js.executeScript(
                    "localStorage.setItem('role', 'SDET');"
            );

            // Verify username exists
            String username =
                    (String) js.executeScript(
                            "return localStorage.getItem('username');"
                    );

            Assert.assertEquals(username, "Vishnu");

            System.out.println(
                    "Before removal: username = " + username
            );

            // Remove username
            js.executeScript(
                    "localStorage.removeItem('username');"
            );

            // Verify username was removed
            String removedUsername =
                    (String) js.executeScript(
                            "return localStorage.getItem('username');"
                    );

            System.out.println(
                    "After removal: username = " + removedUsername
            );

            Assert.assertNull(removedUsername);

            // Verify role still exists
            String role =
                    (String) js.executeScript(
                            "return localStorage.getItem('role');"
                    );

            System.out.println(
                    "Role still exists: " + role
            );

            Assert.assertEquals(role, "SDET");

            // Clear all Local Storage
            js.executeScript(
                    "localStorage.clear();"
            );

            // Verify Local Storage is empty
            Long storageLength =
                    (Long) js.executeScript(
                            "return localStorage.length;"
                    );

            System.out.println(
                    "Local Storage items after clear: "
                            + storageLength
            );

            Assert.assertEquals(storageLength.longValue(), 0L);

            System.out.println(
                    "Local Storage remove and clear test passed!"
            );

        } finally {

            driver.quit();
        }
    }
}