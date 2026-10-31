package tests;

import org.testng.annotations.Test;
import utils.ConfigUtility;

public class ConfigUtilityTest {

    @Test
    public void readConfiguration() {

        ConfigUtility config =
                new ConfigUtility();

        System.out.println(
                "Environment: "
                        + System.getProperty(
                        "environment",
                        "qa"
                )
        );

        System.out.println(
                "Browser: "
                        + config.getProperty("browser")
        );

        System.out.println(
                "Base URL: "
                        + config.getProperty("baseUrl")
        );

        System.out.println(
                "Implicit Wait: "
                        + config.getProperty("implicitWait")
        );

        System.out.println(
                "Explicit Wait: "
                        + config.getProperty("explicitWait")
        );
    }
}