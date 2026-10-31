package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeIndexTest {

    @Test
    public void testIframeByIndex() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {

            // Open iframe page
            driver.get(
                    "https://www.selenium.dev/selenium/web/iframes.html"
            );

            Thread.sleep(3000);

            System.out.println("Page opened.");

            // Switch to first iframe
            driver.switchTo().frame(0);

            System.out.println("Switched to iframe using index 0.");

            Thread.sleep(5000);

            // Return to main page
            driver.switchTo().defaultContent();

            System.out.println("Returned to main page.");

            Thread.sleep(3000);

        } finally {

            driver.quit();
        }
    }
}