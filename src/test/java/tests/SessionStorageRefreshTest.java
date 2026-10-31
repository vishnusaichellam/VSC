package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SessionStorageRefreshTest {

    @Test
    public void sessionStoragePersistsAfterRefresh() {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/");

            JavascriptExecutor js =
                    (JavascriptExecutor) driver;

            // Store data
            js.executeScript(
                    "sessionStorage.setItem('username', 'Vishnu');"
            );

            // Verify before refresh
            String beforeRefresh =
                    (String) js.executeScript(
                            "return sessionStorage.getItem('username');"
                    );

            System.out.println(
                    "Before refresh: " + beforeRefresh
            );

            Assert.assertEquals(
                    beforeRefresh,
                    "Vishnu"
            );

            // Refresh
            driver.navigate().refresh();

            // Verify after refresh
            String afterRefresh =
                    (String) js.executeScript(
                            "return sessionStorage.getItem('username');"
                    );

            System.out.println(
                    "After refresh: " + afterRefresh
            );

            Assert.assertEquals(
                    afterRefresh,
                    "Vishnu"
            );

            System.out.println(
                    "Session Storage persisted after refresh!"
            );

        } finally {

            driver.quit();
        }
    }
}