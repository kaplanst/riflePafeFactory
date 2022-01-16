package tests.menuTest;

import Utils.BaseTest;
import Utils.UtilsMethod;
import model.menus.Footer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FooterTest extends BaseTest {

    Footer footer;

    @BeforeMethod
    void startTests(){
        footer = PageFactory.initElements(driver, Footer.class);
    }

    @Test
    void footersTest (){
        footer.footerViewTest();
    }

    @Test
    void motorcycleProductsTest() throws InterruptedException {
 //       UtilsMethod utilsMethod = PageFactory.initElements(driver,UtilsMethod.class);
        List<WebElement> links = driver.findElements(By.xpath("//*[@class='row']/div[3]/ul/li/a"));
        int i = 0;
        while ( i < links.size()) {
            Thread.sleep(10000);
            links.get(i).click();
//            Thread.sleep(20000);
            System.out.println(links.get(i).getText());
            i++;
 //           driver.navigate().back();
  //          Assert.assertEquals(driver.findElement(By.xpath("//h1")),elem.getText());
        }
    }



}
