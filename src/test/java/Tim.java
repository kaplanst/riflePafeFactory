import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tim {

    @Test
    void fairingsClickTest(){  // Test case #TC-MP-001
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://rifle.com/");
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_NestedMaster_PageContent_webpagePage\"]/div/div[1]/div[1]/a/img")).click();
        Assert.assertEquals(driver.getTitle(), "Fairings");
        driver.quit();
    }

    @Test
    void fairingsTitleTest(){  // Test case #TC-MP-002
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://rifle.com/");
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_NestedMaster_PageContent_webpagePage\"]/div/div[1]/div[1]/a/img")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Fairings");
        driver.quit();
    }

    @Test
    void fairingsSortTest(){  // Test case #TC-MP-003
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://rifle.com/");
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_NestedMaster_PageContent_webpagePage\"]/div/div[1]/div[1]/a/img")).click();
        driver.findElement(By.xpath("//*[@class='form-control-inline']")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_NestedMaster_PageContent_ctl00_SortResults\"]/option[3]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_NestedMaster_PageContent_ctl00_CatalogNodeList_ctl00_CategoryItem_CategoryName\"]")).getText(), "Rifle Cruise Tour Fairing");
        driver.quit();
    }

}
