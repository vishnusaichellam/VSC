package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.AuthenticationUtility;
import utils.ConfigUtility;

public class BaseTest {

    protected WebDriver driver;
    protected AuthenticationUtility authentication;
    protected ConfigUtility config;

    protected int explicitWait;

    @BeforeMethod
    public void setUp() {

        // Load configuration
        config = new ConfigUtility();

        // Read browser from config.properties
        String browser = config.getProperty("browser");

        // Read explicit wait from config.properties
        explicitWait = Integer.parseInt(
                config.getProperty("explicitWait")
        );

        // Start browser
        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else {

            throw new RuntimeException(
                    "Unsupported browser: " + browser
            );
        }

        // Open configured application URL
        driver.get(
                config.getProperty("baseUrl")
        );

        // Create authentication utility
        authentication = new AuthenticationUtility(driver);

        System.out.println(
                "Browser started: " + browser
        );

        System.out.println(
                "Application URL: "
                        + config.getProperty("baseUrl")
        );

        System.out.println(
                "Explicit Wait: "
                        + explicitWait
                        + " seconds"
        );
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Browser closed");
    }
}