package Utils;

import model.menus.Header;
import model.menus.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class UtilsMethod extends BaseTest{

    public WebDriver driver;

    public UtilsMethod(WebDriver driver) {
        this.driver = driver;
    }

    public Properties properties;
    public Header header;
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
        header = PageFactory.initElements(driver, Header.class);
        header.clickLoginButton()
                .fillUsername(getUserName())
                .fillPassword(getUserPassword())
                .clickSigninButton();
        waitForElement(driver, header.logoutButton);
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

    public void headerTest(){
        header = PageFactory.initElements(driver, Header.class);
        Assert.assertTrue(header.logoImage.isDisplayed());
        Assert.assertTrue(header.loginButton.isDisplayed());
        Assert.assertTrue(header.accountButton.isDisplayed());
        Assert.assertTrue(header.wishListButton.isDisplayed());
        Assert.assertTrue(header.cartButton.isDisplayed());
        loginDefault();
        Assert.assertTrue(header.logoutButton.isDisplayed());
        Assert.assertTrue(header.accountButton.isDisplayed());
        Assert.assertTrue(header.wishListButton.isDisplayed());
        Assert.assertTrue(header.cartButton.isDisplayed());
        Assert.assertTrue(header.logoImage.isDisplayed());
    }
}
