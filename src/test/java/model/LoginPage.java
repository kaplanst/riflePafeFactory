package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_UserName")
    WebElement username;
    @FindBy(id = "ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_Password")
    WebElement password;
    @FindBy(id = "ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_LoginButton")
    WebElement signInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage fillUsername (String strUserName){
        username.sendKeys(strUserName);
        return this;
    }

    public LoginPage fillPassword (String strPassword){
        password.sendKeys(strPassword);
        return this;
    }

    public AccountPage clickSigninButton (){
        signInButton.click();
        return PageFactory.initElements(driver, AccountPage.class);
    }

    public AccountPage accountLogin(String strUserName, String strPassword){
        this.fillUsername(strUserName);
        this.fillPassword(strPassword);
        this.clickSigninButton();
        return PageFactory.initElements(driver, AccountPage.class);
    }
}
