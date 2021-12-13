package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public WebDriver driver;

    @FindBy(id = "ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_LoginLink2")
    WebElement loginButton;
    @FindBy(id = "ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootAccountLink")
    WebElement accountButton;
    @FindBy(id = "ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootWishlistLink")
    WebElement wishListButton;
    @FindBy(id = "ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootBasketLink")
    WebElement cartButton;
    @FindBy(xpath = "//div[@class='category-container']//a[@href='Motorcycle-Fairings/Rifle-Fairings.aspx']")
    WebElement fairingsLink;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage clickLoginButton(){
        loginButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }
    public AccountPage clickAccountButton(){
        accountButton.click();
        return PageFactory.initElements(driver, AccountPage.class);
    }
    public WishListPage clickWishlistButton(){
        wishListButton.click();
        return PageFactory.initElements(driver, WishListPage.class);
    }
    public CartPage clickCartButton(){
        cartButton.click();
        return PageFactory.initElements(driver, CartPage.class);
    }
    public MainPage fairing(){
        fairingsLink.click();
        return this;
    }

}
