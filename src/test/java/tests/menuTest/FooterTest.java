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
    void motorcycleProductsTest() {
        for (int i = 0; i < footer.motoProductsArray.length; i++) {
            String path = "//*[@class='row']/div[3]/ul/li[" + (i+1) + "]/a";
            driver.findElement(By.xpath(path)).click();
            Assert.assertEquals(driver.getTitle(), footer.motoProductsArray[i]);
        }
    }
}
