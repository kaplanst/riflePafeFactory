import Utils.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Stan extends BaseTest {

    @Test
    void loginLinkTest() {  // Test case #TC-HD-001
        driver.findElement(By.xpath("//a[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_LoginLink2']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Account Sign In");
        driver.quit();
    }

    @Test
    void loginWithCorrectCredsTest() {  // Test case #TC-HD-002
        driver.get("https://rifle.com/Login.aspx");
        driver.findElement(By.xpath("//input[@id='ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_UserName']")).sendKeys("georgians_forever@gmail.com");
        driver.findElement(By.xpath("//input[@id='ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_Password']")).sendKeys("Qwerty1");
        driver.findElement(By.xpath("//input[@id='ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_LoginButton']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Account Sign In");
        driver.quit();
    }

    @Test
    void loginWithIncorrectCredsTest() {  // Test case #TC-HD-003
        driver.get("https://rifle.com/Login.aspx");
        driver.findElement(By.xpath("//input[@id='ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_UserName']")).sendKeys("georgians_forever@gmail");
        driver.findElement(By.xpath("//input[@id='ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_Password']")).sendKeys("Qwerty1");
        driver.findElement(By.xpath("//input[@id='ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_LoginButton']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='The sign in information you provided was incorrect.']")).isDisplayed());
        driver.quit();
    }

      @Test
    void loginWithEmptyUsernameTest() {  // Test case #TC-HD-004
        driver.get("https://rifle.com/Login.aspx");
        driver.findElement(By.xpath("//input[@id='ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_Password']")).sendKeys("Qwerty1");
        driver.findElement(By.xpath("//input[@id='ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_LoginButton']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You must provide a user name.']")).isDisplayed());
        driver.quit();
    }


}
