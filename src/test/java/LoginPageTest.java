import Utils.BaseTest;
import model.LoginPage;
import model.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;

    @BeforeMethod
    void startTests(){
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void loginLinkTest() {  // Test case #TC-HD-001
        mainPage.clickLoginButton();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Account Sign In");
    }

    @Test
    void loginWithCorrectCredsPOMTest() {  // Test case #TC-HD-002
        loginPage = mainPage.clickLoginButton()
                .fillUsername("georgians_forever@gmail.com")
                .fillPassword("Qwerty1")
                .clickSigninButton();
        Assert.assertEquals(loginPage.getLogOutText(), "Logout");
    }

    @Test
    void loginWithIncorrectCredsTest() {  // Test case #TC-HD-003
        loginPage = mainPage.clickLoginButton()
                .fillUsername("georgians_forever@gmail")
                .fillPassword("Qwerty1")
                .clickSigninButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='The sign in information you provided was incorrect.']")).isDisplayed());
    }

    @Test
    void loginWithEmptyUsernameTest() {  // Test case #TC-HD-004
        loginPage = mainPage.clickLoginButton()
                .fillPassword("Qwerty1")
                .clickSigninButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You must provide a user name.']")).isDisplayed());
    }


}
