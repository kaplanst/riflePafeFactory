import Utils.BaseTest;
import model.LoginPage;
import model.MainPage;
import model.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    MainPage mainPage;
    LoginPage loginPage;
    TopMenu topMenu;

    @BeforeMethod
    void startTests(){
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void loginButtonTest() {  // Test case #TC-HD-001
        mainPage.clickLoginButton();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Account Sign In");
    }

    @Test
    public void accountButtonTest() {
        loginPage = mainPage.clickLoginButton();
        loginPage.accountLogin("georgians_forever@gmail.com", "Qwerty1");
        mainPage.clickAccountButton();
        Assert.assertEquals(driver.getTitle(), "My Account");
    }
    @Test
    public void wishListButtonTest() {
        loginPage = mainPage.clickLoginButton();
        loginPage.accountLogin("georgians_forever@gmail.com", "Qwerty1");
        mainPage.clickWishlistButton();
        Assert.assertEquals(driver.getTitle(), "View Wishlist");
    }
    @Test
    public void cartButtonTest() {
        loginPage = mainPage.clickLoginButton();
        loginPage.accountLogin("georgians_forever@gmail.com", "Qwerty1");
        mainPage.clickCartButton();
        Assert.assertEquals(driver.getTitle(), "My Cart");
    }
    @Test
    public void topMenuTest() {
        topMenu = PageFactory.initElements(driver, TopMenu.class);
//        Assert.assertTrue(topMenu.ho);
    }

}
