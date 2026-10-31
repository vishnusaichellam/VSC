package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowUtility {

    private WebDriver driver;

    public WindowUtility(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentWindow() {
        return driver.getWindowHandle();
    }

    public void switchToChildWindow(String parentWindow) {

        Set<String> allWindows =
                driver.getWindowHandles();

        for (String window : allWindows) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                break;
            }
        }
    }

    public void switchToParentWindow(String parentWindow) {

        driver.switchTo().window(parentWindow);
    }

    public boolean switchToWindowByTitle(String expectedTitle) {

        Set<String> allWindows =
                driver.getWindowHandles();

        for (String window : allWindows) {

            driver.switchTo().window(window);

            if (driver.getTitle().equals(expectedTitle)) {

                return true;
            }
        }

        return false;
    }
}