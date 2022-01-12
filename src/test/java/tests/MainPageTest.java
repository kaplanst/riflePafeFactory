package tests;

import Utils.BaseTest;
import Utils.UtilsMethod;
import model.MainPage;
import model.menus.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    MainPage mainPage;
    UtilsMethod utilsMethod;

    @BeforeMethod
    void startTests() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    void mainPageHeaderTest(){
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        utilsMethod.headerTest();
    }

    @Test
    void menuMainPageTest() {
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        utilsMethod.topMenuFullTest();
    }

}
