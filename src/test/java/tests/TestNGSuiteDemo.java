package tests;

import org.testng.annotations.Test;

public class TestNGSuiteDemo extends BaseTest {

    @Test(groups = "smoke")
    public void loginSmokeTest() {
        System.out.println("Login Smoke Test");
    }

    @Test(groups = "regression")
    public void profileRegressionTest() {
        System.out.println("Profile Regression Test");
    }

    @Test(groups = "regression")
    public void settingsRegressionTest() {
        System.out.println("Settings Regression Test");
    }
}