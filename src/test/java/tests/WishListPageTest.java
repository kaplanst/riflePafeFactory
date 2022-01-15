package tests;

import Utils.BaseTest;
import Utils.UtilsMethod;
import model.menus.Footer;
import model.menus.Header;
import model.menus.TopMenu;
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
        header.headerTest();
    }

    @Test
    void menuTest() {
        TopMenu topMenu = PageFactory.initElements(driver, TopMenu.class);
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        header.clickWishlistButton();
        topMenu.topMenuShortTest();
        utilsMethod.loginDefault();
        header.clickWishlistButton();
        topMenu.topMenuShortTest();
    }

    @Test
    void accountPageFootersTest (){
        header.clickWishlistButton();
        Footer footer = PageFactory.initElements(driver, Footer.class);
        footer.footerShortTest();
    }

}
