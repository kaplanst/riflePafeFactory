package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    @FindBy(xpath = "//h1")
    WebElement header;
    @FindBy(id = "ctl00_ctl00_NestedMaster_PageContent_EmptyBasketMessage")
    WebElement cartEmptyStatus;
    @FindBy(id = "ctl00_ctl00_NestedMaster_PageContent_KeepShoppingButton")
    WebElement keepShoppingButton;
    @FindBy(id = "ctl00_ctl00_PageHeader_StoreHeader_BootNavHomeLink")
    WebElement homeLink;
    @FindBy(xpath = "//input[@value='Clear Cart']")
    WebElement clearCartButton;

    public String getHeaderText(){
        return header.getText();
    }
    public boolean emptyCartIndicator() {
        return cartEmptyStatus.isDisplayed();
    }
    public void keepShopping(){
        keepShoppingButton.click();
    }
    public MainPage goHomePage(){
        homeLink.click();
        return PageFactory.initElements(driver, MainPage.class);
    }
    public CartPage clearCart(){
        clearCartButton.click();
        return PageFactory.initElements(driver, CartPage.class);
    }
    public boolean clearButton(){
        return clearCartButton.isDisplayed();
    }

}
