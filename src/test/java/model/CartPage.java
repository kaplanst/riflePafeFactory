package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    @FindBy(xpath = "//h1")
    WebElement header;

    @FindBy(id = "ctl00_ctl00_NestedMaster_PageContent_EmptyBasketMessage")
    WebElement cartStatus;

    @FindBy(id = "ctl00_ctl00_NestedMaster_PageContent_KeepShoppingButton")
    WebElement keepShopingButton;


}
