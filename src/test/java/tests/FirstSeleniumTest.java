package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    @Test
    public void testPromptAlert() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.selenium.dev/selenium/web/alerts.html");

            WebElement promptLink = driver.findElement(
                    By.xpath("//a[contains(text(),'prompt happen')]")
            );

            promptLink.click();

            Alert alert = driver.switchTo().alert();

            System.out.println("Alert message: " + alert.getText());

            alert.sendKeys("Vishnu");

            alert.accept();

        } finally {
            driver.quit();
        }
    }
}