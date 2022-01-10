import Utils.BaseTest;
import Utils.UtilsMethod;
import model.LoginPage;
import model.MainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListPageTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    UtilsMethod utilsMethod;

    @BeforeMethod
    void startTests() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void wishListButtonTest() {
        loginPage = mainPage.clickLoginButton();
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        utilsMethod.loginDefault();
        mainPage.clickWishlistButton();
        Assert.assertEquals(driver.getTitle(), "View Wishlist");
    }

    @Test
    void menuTest() {
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        mainPage.clickWishlistButton();
        utilsMethod.topMenuShortTest();
        utilsMethod.loginDefault();
        mainPage.clickWishlistButton();
        utilsMethod.topMenuShortTest();
    }



}
