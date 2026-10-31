package tests;

import org.testng.annotations.Test;

public class TestNGLifecycleDemo extends BaseTest {

    @Test
    public void testOne() {

        System.out.println("Executing Test One");
    }

    @Test
    public void testTwo() {

        System.out.println("Executing Test Two");
    }

    @Test
    public void testThree() {

        System.out.println("Executing Test Three");
    }
}