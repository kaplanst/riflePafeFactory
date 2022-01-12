package Utils;

import model.LoginPage;
import model.MainPage;
import model.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.util.Properties;

public class UtilsMethod extends BaseTest{

    public WebDriver driver;

    public UtilsMethod(WebDriver driver) {
        this.driver = driver;
    }

    public Properties properties;
    public MainPage mainPage;
    public TopMenu topMenu;

    public static final String LOGIN_PROP = "username";
    public static final String PAS_PROP = "password";
    public static final String PROPERTY_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\local.properties";


    public String getUserName() {
        try {
            FileInputStream fis = new FileInputStream(PROPERTY_PATH);
            properties = new Properties();
            properties.load(fis);
        }
        catch (Exception e) {
            System.out.println("There is no properties file");
        }
        return properties.getProperty(LOGIN_PROP);
    }

    public String getUserPassword() {
        try {
            FileInputStream fis = new FileInputStream(PROPERTY_PATH);
            properties = new Properties();
            properties.load(fis);
        }
        catch (Exception e) {
            System.out.println("There is no properties file");
        }
        return properties.getProperty(PAS_PROP);
    }

    public void loginDefault(){
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickLoginButton()
                .fillUsername(getUserName())
                .fillPassword(getUserPassword())
                .clickSigninButton();
    }

    public void topMenuShortTest() {
        topMenu = PageFactory.initElements(driver, TopMenu.class);
        Assert.assertTrue(topMenu.shortHomeLink.isDisplayed());
        System.out.println("Test is going well");
        Assert.assertTrue(topMenu.contactUsLink.isDisplayed());
    }

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
}
