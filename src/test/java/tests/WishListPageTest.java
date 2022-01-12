package tests;

import Utils.BaseTest;
import Utils.UtilsMethod;
import model.LoginPage;
import model.menus.Header;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListPageTest extends BaseTest {
    Header header;
    LoginPage loginPage;
    UtilsMethod utilsMethod;

    @BeforeMethod
    void startTests() {
        header = PageFactory.initElements(driver, Header.class);
    }

    @Test
    public void wishListButtonTest() {
        loginPage = header.clickLoginButton();
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        utilsMethod.loginDefault();
        header.clickWishlistButton();
        Assert.assertEquals(driver.getTitle(), "View Wishlist");
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
