package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductItemPage extends BasePage{
/*
    public ProductItemPage(WebDriver driver) {
        super(driver);
    }
    */

    private final By productDesc = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]");
    private final By addtoCartBtn = By.id("add-to-cart-sauce-labs-backpack");

    public String checkProductDescription(){
        String expectedDescText = "unequaled laptop and tablet ";
        String productDescText = getTextElement(productDesc);
        System.out.println(productDescText);
        Assert.assertTrue(productDescText.contains(expectedDescText));
        return productDescText;
    }


    public CartPage addtoCart(){
        clickElement(addtoCartBtn);
        return new CartPage();
    }
}
