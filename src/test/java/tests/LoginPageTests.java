package tests;

import Utils.BaseTest;
import Utils.UtilsMethod;
import model.LoginPage;
import model.menus.Header;
import model.menus.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
    Header header;
    LoginPage loginPage;
    UtilsMethod utilsMethod;

    @BeforeMethod
    void startTests(){
        header = PageFactory.initElements(driver, Header.class);
    }

    @Test
    void loginPageHeaderTest(){
        header.clickLoginButton();
        header.headerTest();
    }

    @Test
    void loginLinkTest() {  // Test case #TC-HD-001
        header.clickLoginButton();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Account Sign In");
    }

    @Test
    void loginWithCorrectCredsPOMTest() {  // Test case #TC-HD-002
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        loginPage = header.clickLoginButton()
                .fillUsername(utilsMethod.getUserName())
                .fillPassword(utilsMethod.getUserPassword())
                .clickSigninButton();
        Assert.assertEquals(loginPage.getLogOutText(), "Logout");
    }

    @Test
    void loginWithIncorrectCredsTest() {  // Test case #TC-HD-003
        loginPage = header.clickLoginButton()
                .fillUsername("Wrong-Email")
                .fillPassword("AnyPassword")
                .clickSigninButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='The sign in information you provided was incorrect.']")).isDisplayed());
    }

    @Test
    void loginWithEmptyUsernameTest() {  // Test case #TC-HD-004
        loginPage = header.clickLoginButton()
                .fillPassword("AnyPassword")
                .clickSigninButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You must provide a user name.']")).isDisplayed());
    }

    @Test
    void defaultLoginTest(){
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        utilsMethod.loginDefault();
        Assert.assertEquals(loginPage.getLogOutText(), "Logout");
    }

    @Test
    void menuTest() {
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        TopMenu topMenu = PageFactory.initElements(driver, TopMenu.class);
        header.clickLoginButton();
        topMenu.topMenuShortTest();
        utilsMethod.loginDefault();
        topMenu.topMenuFullTest();
    }

}
