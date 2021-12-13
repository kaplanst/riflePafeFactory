import Utils.BaseTest;
import model.CartPage;
import model.LoginPage;
import model.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CartPageTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    CartPage cartPage;

    @BeforeMethod
    void startTests() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        loginPage = mainPage.clickLoginButton();
        loginPage.accountLogin("georgians_forever@gmail.com", "Qwerty1");
        cartPage = mainPage.clickCartButton();
    }

    @Test
    void headerTest(){
        Assert.assertEquals(cartPage.getHeaderText(), "My Shopping Cart");
    }

    @Test
    void emptyCartTest(){
        Assert.assertTrue(cartPage.emptyCartIndicator());
    }

    @Test
    void continueShoppingTest() throws InterruptedException {
        cartPage.goHomePage()
                .fairing();
        String tempTitle = driver.getTitle();
        mainPage.clickCartButton()
                .keepShopping();
        Thread.sleep(500);
        Assert.assertEquals(tempTitle, driver.getTitle());
    }
}