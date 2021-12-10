package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void fillUsername (String strUserName){
        username.sendKeys(strUserName);
    }

    public void fillPassword (String strPassword){
        password.sendKeys(strPassword);
    }

    public void clickSigninButton (){
        signInButton.click();
    }
}
