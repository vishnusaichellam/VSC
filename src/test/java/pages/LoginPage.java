package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.id("loginButton");
    private By message = By.id("message");

    public LoginPage(
            WebDriver driver,
            int explicitWaitSeconds
    ) {
        super(driver, explicitWaitSeconds);
    }

    public void enterUsername(String usernameValue) {
        clearAndType(username, usernameValue);
    }

    public void enterPassword(String passwordValue) {
        clearAndType(password, passwordValue);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public String getLoginMessage() {
        return getText(message);
    }

    public void login(
            String usernameValue,
            String passwordValue
    ) {
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickLogin();
    }
}