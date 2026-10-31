package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class NestedIframeTest {

    @Test
    public void testNestedIframe() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {

            // 1. Open local HTML
            File htmlFile = new File("nested_iframe.html");

            driver.get(htmlFile.toURI().toString());

            Thread.sleep(3000);

            System.out.println("Main page opened.");

            // 2. Find outer iframe
            WebElement outerFrame = driver.findElement(
                    By.id("outerFrame")
            );

            System.out.println("Outer iframe found.");

            Thread.sleep(2000);

            // 3. Switch into outer iframe
            driver.switchTo().frame(outerFrame);

            System.out.println("Switched into outer iframe.");

            Thread.sleep(3000);

            // 4. Find inner iframe
            WebElement innerFrame = driver.findElement(
                    By.id("innerFrame")
            );

            System.out.println("Inner iframe found.");

            Thread.sleep(2000);

            // 5. Switch into inner iframe
            driver.switchTo().frame(innerFrame);

            System.out.println("Switched into inner iframe.");

            Thread.sleep(3000);

            // 6. Find input inside inner iframe
            WebElement input = driver.findElement(
                    By.id("nameInput")
            );

            System.out.println("Input found.");

            Thread.sleep(2000);

            // 7. Type text
            input.sendKeys("Vishnu");

            System.out.println("Typed: Vishnu.");

            Thread.sleep(5000);

            // 8. Verify result
            String result = driver.findElement(
                    By.id("result")
            ).getText();

            System.out.println("Result: " + result);

            Assert.assertEquals(result, "Vishnu");

            Thread.sleep(3000);

            // 9. Return directly to main page
            driver.switchTo().defaultContent();

            System.out.println("Returned to main page.");

            Thread.sleep(3000);

        } finally {

            driver.quit();
        }
    }
}