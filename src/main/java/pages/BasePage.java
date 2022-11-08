package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasePage {

    // protected WebDriver driver;
    WebDriverWait wait;

  /*  public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }*/

    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    protected void clickElement(By locator) {
        try {
          //  wait.withMessage("Wait for " + locator + "element");
          //  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            DriverManager.getDr().findElement(locator).click();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void enterText(By locator, String text) {
        try {
           // wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            DriverManager.getDr().findElement(locator).sendKeys(text);
        } catch (Exception exception) {

            exception.printStackTrace();
        }

    }

    public String getTextElement(By locator) {
        String text = null;
        try {
           // wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            text = DriverManager.getDr().findElement(locator).getText();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return text;
    }

    public void chooseElementFromDropDown(By locator, String textToChoose) {
        try {
           // wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Select selectOption = new Select(DriverManager.getDr().findElement(locator));
            selectOption.selectByValue(textToChoose);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    protected String getText(By locator) {
        String text = null;
        try {
           // wait.withMessage("Wait for " + locator + "element");
          //  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            text = DriverManager.getDr().findElement(locator).getText();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return text;
    }

    protected List<WebElement> findElementsInList(By locator) {
        List<WebElement> webElements = null;
        try {
           // wait.withMessage("Wait for " + locator + "element");
           // wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            webElements = DriverManager.getDr().findElements(locator);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return webElements;
    }
}
