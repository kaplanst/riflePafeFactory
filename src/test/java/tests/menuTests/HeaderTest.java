package tests.menuTests;

import Utils.BaseTest;
import model.LoginPage;
import model.menus.Header;
import model.menus.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {

    Header header;
    LoginPage loginPage;
    TopMenu topMenu;

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
    public void accountButtonTest() {
        loginPage = header.clickLoginButton();
        loginPage.accountLogin("georgians_forever@gmail.com", "Qwerty1");
        header.clickAccountButton();
        Assert.assertEquals(driver.getTitle(), "My Account");
    }
    @Test
    public void wishListButtonTest() {
        loginPage = header.clickLoginButton();
        loginPage.accountLogin("georgians_forever@gmail.com", "Qwerty1");
        header.clickWishlistButton();
        Assert.assertEquals(driver.getTitle(), "View Wishlist");
    }
    @Test
    public void cartButtonTest() {
        loginPage = header.clickLoginButton();
        loginPage.accountLogin("georgians_forever@gmail.com", "Qwerty1");
        header.clickCartButton();
        Assert.assertEquals(driver.getTitle(), "My Cart");
    }
    @Test
    public void topMenuFullTest() {
        topMenu = PageFactory.initElements(driver, TopMenu.class);
        Assert.assertTrue(topMenu.homeLink.isDisplayed());
        Assert.assertTrue(topMenu.searchByModelsLink.isDisplayed());
        Assert.assertTrue(topMenu.contactRifleLink.isDisplayed());
        Assert.assertTrue(topMenu.productsDropDown.isDisplayed());
        Assert.assertTrue(topMenu.aboutAsLink.isDisplayed());

        topMenu.checkInfoDropDown();
        Assert.assertTrue(topMenu.windshieldSelectionGuide.isDisplayed());
        Assert.assertTrue(topMenu.orderInfo.isDisplayed());
        Assert.assertTrue(topMenu.becomeDealer.isDisplayed());
        Assert.assertTrue(topMenu.inquireAboutCustomManufacturing.isDisplayed());

        topMenu.checkProductsDropDown("  Products");
        Assert.assertTrue(topMenu.justReleasedLink.isDisplayed());
    }
    @Test
    public void topMenuShortTest() {
        topMenu = PageFactory.initElements(driver, TopMenu.class);
        Assert.assertTrue(topMenu.homeLink.isDisplayed());

    }
}
