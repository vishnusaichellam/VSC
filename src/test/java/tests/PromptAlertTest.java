package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class PromptAlertTest {

    @Test
    public void testPromptAlert() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {

            // Open local HTML page
            File htmlFile = new File("prompt_alert.html");
            driver.get(htmlFile.toURI().toString());

            // Keep page visible for 3 seconds
            Thread.sleep(3000);

            // Click Open Prompt
            driver.findElement(By.id("promptButton")).click();

            // Keep prompt visible before typing
            Thread.sleep(3000);

            // Switch to prompt
            Alert alert = driver.switchTo().alert();

            System.out.println("Alert message: " + alert.getText());

            // Pause so you can see the empty prompt
            Thread.sleep(2000);

            // Enter Vishnu
            alert.sendKeys("Vishnu");

            // Keep Vishnu visible for 5 seconds
            Thread.sleep(5000);

            // Click OK
            alert.accept();

            // Wait so you can see the webpage after accepting
            Thread.sleep(3000);

            // Read result
            String result = driver.findElement(
                    By.id("result")
            ).getText();

            System.out.println("Result: " + result);

            // Verify
            Assert.assertEquals(result, "Vishnu");

            // Keep result visible
            Thread.sleep(3000);

        } finally {

            driver.quit();
        }
    }
}