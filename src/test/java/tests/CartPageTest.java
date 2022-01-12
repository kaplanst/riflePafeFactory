package tests;

import Utils.BaseTest;
import Utils.UtilsMethod;
import model.CartPage;
import model.ItemPage;
import model.LoginPage;
import model.menus.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {
    Header header;
    LoginPage loginPage;
    CartPage cartPage;
    ItemPage itemPage;
    UtilsMethod utilsMethod;

    @BeforeMethod
    void startTests() {
        header = PageFactory.initElements(driver, Header.class);
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        utilsMethod.loginDefault();
        cartPage = header.clickCartButton();
        cartPage.clearCart();
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
        header.clickCartButton()
                .keepShopping();
        Thread.sleep(500);
        Assert.assertEquals(tempTitle, driver.getTitle());
    }
    @Test
    void itemAddToCartTest() {
        itemPage = PageFactory.initElements(driver, ItemPage.class);
        driver.get(ITEM_1);
        String item = itemPage.getHeaderText();
        itemPage.clickAddToCartButton();
        header.clickCartButton();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='itemDetail basketItemDetail']/a")).getText(), item);
    }
    @Test
    void multiplyItemsInCartTest() {
        itemPage = PageFactory.initElements(driver, ItemPage.class);
        driver.get(ITEM_1);
        itemPage.clickAddToCartButton();
        header.clickCartButton();
        cartPage.changingItemQuantity(Integer.toString(ITEM_QUANTITY));
    }

    @Test
    void menuTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        utilsMethod.topMenuShortTest();
        loginPage.logOutButton.click();
        header.clickCartButton();
        utilsMethod.topMenuShortTest();
    }

}
