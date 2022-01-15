package tests;

import Utils.BaseTest;
import model.MainPage;
import model.menus.Footer;
import model.menus.Header;
import model.menus.TopMenu;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    MainPage mainPage;

    @BeforeMethod
    void startTests() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    void mainPageHeaderTest(){
        Header header = PageFactory.initElements(driver, Header.class);
        header.headerTest();
    }

    @Test
    void menuMainPageTest() {
        TopMenu topMenu  = PageFactory.initElements(driver, TopMenu.class);
        topMenu.topMenuFullTest();
    }

    @Test
    void mainPageFootersTest (){
        Footer footer = PageFactory.initElements(driver, Footer.class);
        footer.headerFootersTest();
    }

}
