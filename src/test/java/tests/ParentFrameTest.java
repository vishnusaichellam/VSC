package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class ParentFrameTest {

    @Test
    public void testParentFrame() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {

            File htmlFile = new File("nested_iframe.html");
            driver.get(htmlFile.toURI().toString());

            Thread.sleep(3000);

            System.out.println("Main page opened.");

            // Main → Outer
            WebElement outerFrame =
                    driver.findElement(By.id("outerFrame"));

            driver.switchTo().frame(outerFrame);

            System.out.println("Switched to OUTER iframe.");

            Thread.sleep(3000);

            // Outer → Inner
            WebElement innerFrame =
                    driver.findElement(By.id("innerFrame"));

            driver.switchTo().frame(innerFrame);

            System.out.println("Switched to INNER iframe.");

            Thread.sleep(3000);

            // Interact inside Inner
            WebElement input =
                    driver.findElement(By.id("nameInput"));

            input.sendKeys("Vishnu");

            System.out.println("Typed Vishnu inside INNER iframe.");

            Thread.sleep(3000);

            // Inner → Outer
            driver.switchTo().parentFrame();

            System.out.println("Moved back to OUTER iframe.");

            Thread.sleep(3000);

            // Outer → Main
            driver.switchTo().parentFrame();

            System.out.println("Moved back to MAIN page.");

            Thread.sleep(3000);

        } finally {

            driver.quit();
        }
    }
}