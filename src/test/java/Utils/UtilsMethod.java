package Utils;

import model.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class UtilsMethod extends BaseTest{

    public WebDriver driver;

    public UtilsMethod(WebDriver driver) {
        this.driver = driver;
    }

    public Properties properties;
    public MainPage mainPage;

    public static final String LOGIN_PROP = "default.username";
    public static final String PAS_PROP = "default.password";
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
}
