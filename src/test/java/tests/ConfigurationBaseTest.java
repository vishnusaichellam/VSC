package tests;

import org.testng.annotations.Test;

public class ConfigurationBaseTest extends BaseTest {

    @Test
    public void verifyConfigurationBasedBrowser() {

        System.out.println(
                "Page Title: " + driver.getTitle()
        );

        System.out.println(
                "Current URL: " + driver.getCurrentUrl()
        );
    }
}