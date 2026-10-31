package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {

    @Test
    public void testIframe() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {

            // 1. Open iframe page
            driver.get(
                    "https://www.selenium.dev/selenium/web/iframes.html"
            );
            driver.manage().window().maximize();
            Thread.sleep(3000);

            // 2. Find iframe
            WebElement frame = driver.findElement(
                    By.id("iframe1")
            );

            System.out.println("Iframe found.");

            Thread.sleep(2000);

            // 3. Switch into iframe
            driver.switchTo().frame(frame);

            System.out.println("Switched into iframe.");

            Thread.sleep(3000);

            // 4. Print the page source inside the iframe
            System.out.println(
                    "Inside iframe title: " + driver.getTitle()
            );

            Thread.sleep(3000);

            // 5. Return to main page
            driver.switchTo().defaultContent();

            System.out.println("Returned to main page.");

            Thread.sleep(3000);

        } finally {

            driver.quit();
        }
    }
}