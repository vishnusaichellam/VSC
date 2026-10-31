package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifySuccessfulLogin() {

        driver.get(
                "file:///D:/Intellija/SDET-Automation/SDET-Automation2/test-pages/login-demo.html"
        );

        LoginPage loginPage =
                new LoginPage(
                        driver,
                        explicitWait
                );

        loginPage.login(
                "Vishnu",
                "12345"
        );

        String message =
                loginPage.getLoginMessage();

        System.out.println(
                "Login message: " + message
        );

        Assert.assertEquals(
                message,
                "Login successful"
        );
    }
}