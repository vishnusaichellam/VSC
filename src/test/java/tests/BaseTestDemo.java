package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTestDemo extends BaseTest {

    @Test
    public void verifyPageTitle() {

        String title = driver.getTitle();

        System.out.println("Page title: " + title);

        Assert.assertEquals(title, "Base Test Demo");
    }

    @Test
    public void verifyPageStatus() {

        String status =
                driver.findElement(
                        org.openqa.selenium.By.id("status")
                ).getText();

        System.out.println("Status: " + status);

        Assert.assertEquals(
                status,
                "Application loaded successfully"
        );
    }
}