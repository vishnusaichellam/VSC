package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.WindowUtility;

import java.io.File;

public class MultipleWindowsTest {

    @Test
    public void testMultipleWindows() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {

            // Create WindowUtility
            WindowUtility windowUtility =
                    new WindowUtility(driver);

            // Open parent page
            File htmlFile =
                    new File("multiple_windows.html");

            driver.get(htmlFile.toURI().toString());

            Thread.sleep(3000);

            System.out.println("Parent window opened.");

            // Save parent window handle
            String parentWindow =
                    windowUtility.getCurrentWindow();

            System.out.println(
                    "Parent Window Handle: " + parentWindow
            );

            Thread.sleep(2000);

            // Open child window
            driver.findElement(
                    By.id("openChild")
            ).click();

            System.out.println(
                    "Child window opened."
            );

            Thread.sleep(3000);

            // Switch to Child using TITLE
            boolean found =
                    windowUtility.switchToWindowByTitle(
                            "Child Window"
                    );

            Assert.assertTrue(found);

            System.out.println(
                    "Switched to Child Window by title."
            );

            Thread.sleep(3000);

            // Verify child
            System.out.println(
                    "Current title: " + driver.getTitle()
            );

            // Interact with child
            driver.findElement(
                    By.id("childInput")
            ).sendKeys("Vishnu");

            System.out.println(
                    "Typed Vishnu in child window."
            );

            Thread.sleep(5000);

            // Close child
            driver.close();

            System.out.println(
                    "Child window closed."
            );

            Thread.sleep(2000);

            // Switch back to parent
            windowUtility.switchToParentWindow(
                    parentWindow
            );

            System.out.println(
                    "Switched back to parent."
            );

            Thread.sleep(3000);

            // Verify parent
            System.out.println(
                    "Parent title: " + driver.getTitle()
            );

            Assert.assertEquals(
                    driver.getTitle(),
                    "Multiple Windows Demo"
            );

            Thread.sleep(3000);

        } finally {

            driver.quit();
        }
    }
}