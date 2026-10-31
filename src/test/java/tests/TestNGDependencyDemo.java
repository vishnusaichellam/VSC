package tests;

import org.testng.annotations.Test;

public class TestNGDependencyDemo extends BaseTest {

    @Test
    public void loginTest() {

        System.out.println("Login Test");
    }
    @Test(dependsOnMethods = "loginTest")
    public void checkoutTest() {

        System.out.println("Checkout Test");
    }

    @Test(dependsOnMethods = "checkoutTest")
    public void paymentTest() {

        System.out.println("Payment Test");
    }
}