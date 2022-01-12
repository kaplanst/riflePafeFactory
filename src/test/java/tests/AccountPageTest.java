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
    UtilsMethod utilsMethod;

    @BeforeMethod
    void startTests(){
        header = PageFactory.initElements(driver, Header.class);
    }

    @Test
    void loginPageHeaderTest(){
        header.clickAccountButton();
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        utilsMethod.headerTest();
    }

    @Test
    void menuAccountPageTest() {
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        header.clickAccountButton();
        utilsMethod.topMenuShortTest();
        utilsMethod.loginDefault();
        header.clickAccountButton();
        utilsMethod.topMenuShortTest();
    }


}
