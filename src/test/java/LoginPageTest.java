import Utils.BaseTest;
import Utils.UtilsMethod;
import model.LoginPage;
import model.MainPage;
import model.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    UtilsMethod utilsMethod;
    TopMenu topMenu;

    @BeforeMethod
    void startTests(){
        mainPage = PageFactory.initElements(driver, MainPage.class);

    }

    @Test
    void loginLinkTest() {  // Test case #TC-HD-001
        mainPage.clickLoginButton();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Account Sign In");
    }

    @Test
    void loginWithCorrectCredsPOMTest() {  // Test case #TC-HD-002
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        loginPage = mainPage.clickLoginButton()
                .fillUsername(utilsMethod.getUserName())
                .fillPassword(utilsMethod.getUserPassword())
                .clickSigninButton();
        Assert.assertEquals(loginPage.getLogOutText(), "Logout");
    }

    @Test
    void loginWithIncorrectCredsTest() {  // Test case #TC-HD-003
        loginPage = mainPage.clickLoginButton()
                .fillUsername("Wrong-Email")
                .fillPassword("AnyPassword")
                .clickSigninButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='The sign in information you provided was incorrect.']")).isDisplayed());
    }

    @Test
    void loginWithEmptyUsernameTest() {  // Test case #TC-HD-004
        loginPage = mainPage.clickLoginButton()
                .fillPassword("AnyPassword")
                .clickSigninButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You must provide a user name.']")).isDisplayed());
    }

    @Test
    void defaultLoginTest(){
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        utilsMethod.loginDefault();
        Assert.assertEquals(loginPage.getLogOutText(), "Logout");
    }

    @Test
    void menuTest() {
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        mainPage.clickLoginButton();
        utilsMethod.topMenuShortTest();
        utilsMethod.loginDefault();
        utilsMethod.topMenuFullTest();
    }

}
