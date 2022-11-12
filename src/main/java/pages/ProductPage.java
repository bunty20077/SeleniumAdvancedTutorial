package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {

    private static String url = "https://www.saucedemo.com/";

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By sauceLabsBackpackProduct = By.id("item_4_title_link");
    private final By headerText = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private final By filterDropdown = By.className("product_sort_container");
    private final By priceOfItemsElements = By.className("inventory_item_price");

    /*
        public ProductPage(WebDriver driver) {
            super(driver);
        }
    */
    public ProductItemPage clickProduct() {
        clickElement(sauceLabsBackpackProduct);
        return new ProductItemPage();
    }

    public String getInventoryPageTitle() {
        return getText(headerText);
    }

    public ProductPage filterByPrice(String chooseElementText) {
        chooseElementFromDropDown(filterDropdown, chooseElementText);
        // checkfilteredItemByPrice();
        return this;
    }

    /*
     * Method checks the order of items based on low high to high price.
     * ArrayList is used to enter item price in order which is expectedList
     * Another arraylist named actualList is used to capture price using classname locator and add in actualList arraylist.
     * Then both arraylist is compared.
     */
    public List<String> checkfilteredItemByPrice() {

        List<WebElement> elementNames = findElementsInList(priceOfItemsElements);
        List<String> actualList = new ArrayList<String>();
        elementNames.forEach(elementName -> actualList.add(elementName.getText()));
        // Assert.assertEquals(expectedList,actualList);
        return actualList;
    }

    public List<String> assertFlteredItemByPrice() {

        List<String> expectedList = new ArrayList<String>();

        expectedList.add("$7.99");
        expectedList.add("$9.99");
        expectedList.add("$15.99");
        expectedList.add("$15.99");
        expectedList.add("$29.99");
        expectedList.add("$49.99");

        return expectedList;
    }
}
