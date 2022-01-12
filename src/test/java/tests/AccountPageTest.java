package tests;

import Utils.BaseTest;
import Utils.UtilsMethod;
import model.LoginPage;
import model.menus.Header;
import model.menus.TopMenu;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest {
    Header header;
    LoginPage loginPage;
    TopMenu topMenu;
    UtilsMethod utilsMethod;

    @BeforeMethod
    void startTests(){
        header = PageFactory.initElements(driver, Header.class);
    }

    @Test
    public void accountLinkTest() {
        loginPage = header.clickLoginButton();
        loginPage.accountLogin("georgians_forever@gmail.com", "Qwerty1");
        header.clickAccountButton();
        Assert.assertEquals(driver.getTitle(), "My Account");
    }

    @Test
    void menuTest() {
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        header.clickAccountButton();
        utilsMethod.topMenuShortTest();
        utilsMethod.loginDefault();
        header.clickAccountButton();
        utilsMethod.topMenuShortTest();
    }


}
