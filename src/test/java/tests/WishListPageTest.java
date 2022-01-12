package tests;

import Utils.BaseTest;
import Utils.UtilsMethod;
import model.menus.Header;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListPageTest extends BaseTest {
    Header header;
    UtilsMethod utilsMethod;

    @BeforeMethod
    void startTests() {
        header = PageFactory.initElements(driver, Header.class);
    }

    @Test
    void wishListHeaderTest(){
        header.clickWishlistButton();
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        utilsMethod.headerTest();
    }

    @Test
    void menuTest() {
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        header.clickWishlistButton();
        utilsMethod.topMenuShortTest();
        utilsMethod.loginDefault();
        header.clickWishlistButton();
        utilsMethod.topMenuShortTest();
    }
}
