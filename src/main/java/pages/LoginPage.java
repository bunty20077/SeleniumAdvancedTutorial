package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    WebDriver driver;
    private static String url = "https://www.saucedemo.com/";


   public loginPage( WebDriver driver )
    {
        PageFactory.initElements( driver, this);
        this.driver = driver;
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

    public void launchUrl(){

        driver.get(url);
    }


}
