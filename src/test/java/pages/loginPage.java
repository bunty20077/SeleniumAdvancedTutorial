package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverFactory;

public class loginPage {

    WebDriver driver;


   public loginPage( WebDriver driver )
    {
        PageFactory.initElements( driver, this);
    }



    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public  void enterLoginDetails(String username, String password) {

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();



    }


}
