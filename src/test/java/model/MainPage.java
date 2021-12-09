package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    WebDriver driver;

    @FindBy(xpath = "//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_LoginLink2']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootAccountLink']")
    WebElement accountButton;

    @FindBy(xpath = "//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootWishlistLink']")
    WebElement wishListButton;

    @FindBy(xpath = "//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootBasketLink']")
    WebElement cartButton;

    public LoginPage clickLoginButton(){
 //       driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_LoginLink2']")).click();
        loginButton.click();
        return new LoginPage(driver);
    }


}
