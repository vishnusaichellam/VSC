package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtility;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtility wait;

    public BasePage(WebDriver driver, int explicitWaitSeconds) {

        this.driver = driver;

        this.wait = new WaitUtility(
                driver,
                explicitWaitSeconds
        );
    }

    protected void click(By locator) {
        wait.waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        wait.waitForVisibility(locator).sendKeys(text);
    }

    protected void clearAndType(By locator, String text) {
        wait.waitForVisibility(locator).clear();
        wait.waitForVisibility(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return wait.waitForVisibility(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        return wait.waitForVisibility(locator).isDisplayed();
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    protected void goBack() {
        driver.navigate().back();
    }

    protected void goForward() {
        driver.navigate().forward();
    }
}