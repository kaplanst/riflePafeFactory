import Utils.BaseTest;
import Utils.UtilsMethod;
import model.LoginPage;
import model.MainPage;
import model.TopMenu;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    TopMenu topMenu;
    UtilsMethod utilsMethod;

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

    @Test
    void menuTest() {
        utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        mainPage.clickAccountButton();
        utilsMethod.topMenuShortTest();
        utilsMethod.loginDefault();
        mainPage.clickAccountButton();
        utilsMethod.topMenuShortTest();
    }


}
