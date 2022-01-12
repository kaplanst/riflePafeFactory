package model.menus;

import model.AccountPage;
import model.CartPage;
import model.LoginPage;
import model.WishListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    public WebDriver driver;

    @FindBy(xpath = "//img[contains(@src, 'logo.png')]")
    public WebElement logoImage;
    @FindBy(xpath = "//li[@class='login']/a[contains(@href, 'Login.aspx')]")
    public WebElement loginButton;
    @FindBy(xpath = "//li[@class='login']//*[contains(@id, 'LogoutLink2')]")
    public WebElement logoutButton;
    @FindBy(xpath = "//a[contains(@id, 'BootAccountLink')]")
    public WebElement accountButton;
    @FindBy(xpath = "//a[contains(@id, 'BootWishlistLink')]")
    public WebElement wishListButton;
    @FindBy(xpath = "//a[contains(@id, 'BootBasketLink')]")
    public WebElement cartButton;
    @FindBy(xpath = "//div[@class='category-container']//a[@href='Motorcycle-Fairings/Rifle-Fairings.aspx']")
    public WebElement fairingsLink;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public AccountPage clickAccountButton() {
        accountButton.click();
        return PageFactory.initElements(driver, AccountPage.class);
    }

    public WishListPage clickWishlistButton() {
        wishListButton.click();
        return PageFactory.initElements(driver, WishListPage.class);
    }

    public CartPage clickCartButton() {
        cartButton.click();
        return PageFactory.initElements(driver, CartPage.class);
    }

    public void logoutButtonClick() {
        logoutButton.click();
    }

    public Header fairing() {
        fairingsLink.click();
        return this;
    }

}
