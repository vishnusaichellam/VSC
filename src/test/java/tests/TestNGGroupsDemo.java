package tests;

import org.testng.annotations.Test;

public class TestNGGroupsDemo extends BaseTest {

    @Test(groups = "smoke")
    public void loginTest() {
        System.out.println("Executing Login Test");
    }

    @Test(groups = "regression")
    public void checkoutTest() {
        System.out.println("Executing Checkout Test");
    }

    @Test(groups = "smoke")
    public void searchTest() {
        System.out.println("Executing Search Test");
    }

    @Test(groups = "regression")
    public void paymentTest() {
        System.out.println("Executing Payment Test");
    }
}