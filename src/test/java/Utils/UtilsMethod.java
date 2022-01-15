package Utils;

import model.menus.Header;
import model.menus.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void scroll(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollClick(WebDriver driver, WebElement element) {
        scroll(driver, element);
        element.click();
    }

}
