package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static final String ITEM_1 = "https://rifle.com/Motorcycle-Windshields/Accessories/Air-Balance-Windshield-Vent-Kit.aspx?ItemId=369099";
    public static final int ITEM_QUANTITY = 5;

    public WebDriver driver;

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
