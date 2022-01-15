package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static final String ITEM_1 = "https://rifle.com/Motorcycle-Windshields/Accessories/Air-Balance-Windshield-Vent-Kit.aspx?ItemId=369099";
    public static final int ITEM_QUANTITY = 5;

    public WebDriver driver;

    public void waitForElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rifle.com/");
    }

    @AfterMethod
    public void byeBye(){
       driver.quit();
    }
}