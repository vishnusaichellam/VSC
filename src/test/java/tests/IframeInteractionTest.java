package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeInteractionTest {

    @Test
    public void testIframeInteraction() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {

            // Open iframe page
            driver.get(
                    "https://www.selenium.dev/selenium/web/iframes.html"
            );

            Thread.sleep(3000);

            // Find iframe
            WebElement frame = driver.findElement(
                    By.id("iframe1")
            );

            System.out.println("Iframe found.");

            Thread.sleep(2000);

            // Switch into iframe
            driver.switchTo().frame(frame);

            System.out.println("Switched into iframe.");

            // Keep iframe visible for 5 seconds
            Thread.sleep(5000);

            // Get all links inside the iframe
            java.util.List<WebElement> links =
                    driver.findElements(By.tagName("a"));

            System.out.println(
                    "Links inside iframe: " + links.size()
            );

            // Display the text of each link
            for (WebElement link : links) {

                System.out.println(
                        "Link text: " + link.getText()
                );
            }

            Thread.sleep(5000);

            // Return to main document
            driver.switchTo().defaultContent();

            System.out.println("Returned to main page.");

            Thread.sleep(3000);

        } finally {

            driver.quit();
        }
    }
}