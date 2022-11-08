package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    private static final By usernameField = By.id("user-name");
    private static final By passwordField = By.id("password");
    private static final By loginBtn = By.id("login-button");

/*
    public LoginPage(WebDriver driver) {
        super(driver);
    }
*/

    public LoginPage enterUsername(String username) {
        enterText(usernameField, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enterText(passwordField, password);
        return this;
    }

    public ProductPage submitLogin() {
        clickElement(loginBtn);
        return new ProductPage();
    }
}
