package tests;

import Utils.BaseTest;
import Utils.UtilsMethod;
import model.LoginPage;
import model.menus.Footer;
import model.menus.Header;
import model.menus.TopMenu;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest {
    Header header;

    @BeforeMethod
    void startTests(){
        header = PageFactory.initElements(driver, Header.class);
    }

    @Test
    void loginPageHeaderTest(){
        header.clickAccountButton();
        header.headerTest();
    }

    @Test
    void menuAccountPageTest() {
        TopMenu topMenu = PageFactory.initElements(driver, TopMenu.class);
        UtilsMethod utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        header.clickAccountButton();
        topMenu.topMenuShortTest();
        utilsMethod.loginDefault();
        header.clickAccountButton();
        topMenu.topMenuShortTest();
    }

    @Test
    void accountPageFootersTest (){
        header.clickAccountButton();
//        Footer footer = PageFactory.initElements(driver, Footer.class);
//        footer.headerFootersTest();
    }


}
