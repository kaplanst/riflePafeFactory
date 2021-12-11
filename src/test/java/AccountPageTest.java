import Utils.BaseTest;
import model.LoginPage;
import model.MainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;

    @BeforeMethod
    void startTests(){
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void accountLinkTest() {
        loginPage = mainPage.clickLoginButton();
        loginPage.accountLogin("georgians_forever@gmail.com", "Qwerty1");
        mainPage.clickAccountButton();
        Assert.assertEquals(driver.getTitle(), "My Account");
    }

}
