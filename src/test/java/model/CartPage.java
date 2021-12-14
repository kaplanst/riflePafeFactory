package model;

import org.openqa.selenium.Keys;
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
    @FindBy(xpath = "//span[@class='basket']/input[2]")
    WebElement clearCartButton;
    @FindBy (id = "ctl00_ctl00_NestedMaster_PageContent_BasketGrid_ctl02_Quantity")
    WebElement quantity;

    public String getHeaderText() {
        return header.getText();
    }

    public boolean emptyCartIndicator() {
        return cartEmptyStatus.isDisplayed();
    }

    public void keepShopping() {
        keepShoppingButton.click();
    }

    public MainPage goHomePage() {
        homeLink.click();
        return PageFactory.initElements(driver, MainPage.class);
    }

    public CartPage clearCart() {
        try {
            clearCartButton.click();
            driver.switchTo().alert().accept();
        } catch (Exception e) {
        }
        return PageFactory.initElements(driver, CartPage.class);
    }

    public CartPage changingItemQuantity(String intQuant) {
        quantity.sendKeys(Keys.BACK_SPACE, intQuant, Keys.ENTER);
        return this;


    }
}