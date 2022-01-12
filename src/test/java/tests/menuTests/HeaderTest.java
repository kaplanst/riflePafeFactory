package tests.menuTests;

import Utils.BaseTest;
import Utils.UtilsMethod;
import model.LoginPage;
import model.menus.Header;
import model.menus.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HeaderTest extends BaseTest {

    Header header;
    UtilsMethod utils;

    @BeforeMethod
    void startTests(){
        header = PageFactory.initElements(driver, Header.class);
    }

    @Test
    public void loginButtonTest() {  // Test case #TC-HD-001
        header.clickLoginButton();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Account Sign In");
    }
    @Test
    public void accountButtonTest() throws InterruptedException {
        utils = PageFactory.initElements(driver, UtilsMethod.class);
        utils.loginDefault();
        Thread.sleep(500);
        header.clickAccountButton();
        Assert.assertEquals(driver.getTitle(), "My Account");
    }
    @Test
    public void wishListButtonTest() {
        utils = PageFactory.initElements(driver, UtilsMethod.class);
        utils.loginDefault();
        header.clickWishlistButton();
        Assert.assertEquals(driver.getTitle(), "View Wishlist");
    }
    @Test
    public void cartButtonTest() {
        utils = PageFactory.initElements(driver, UtilsMethod.class);
        utils.loginDefault();
        header.clickCartButton();
        Assert.assertEquals(driver.getTitle(), "My Cart");
    }
    @Test
    public void logoutButtonTest() {
        utils = PageFactory.initElements(driver, UtilsMethod.class);
        utils.loginDefault();
        header.logoutButtonClick();
        Assert.assertTrue(header.loginButton.isDisplayed());
    }
    @Test
    public void logoTest() {
        Assert.assertTrue(header.logoImage.isDisplayed());
    }
}
