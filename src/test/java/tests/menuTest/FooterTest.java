package tests.menuTest;

import Utils.BaseTest;
import model.menus.Footer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test
    void searchByMakeTest() {
        for (int i = 0; i < 12; i++) {
            String brand =  driver.findElement(By.xpath("//div[@id='footerMiddle']//div[2]/ul/li[" + (i+1) + "]/a")).getText();
            driver.findElement(By.xpath("//div[@id='footerMiddle']//div[2]/ul/li[" + (i+1) + "]/a")).click();
            if (brand.equals("Can-Am")) brand = "Bombardier";
            System.out.println(driver.getTitle() + " ---- " + brand);
            Assert.assertTrue(driver.getTitle().contains(brand));
        }
    }

    @Test
    void onlineStoreTest() {
        for (int i = 0; i < 4; i++) {
            String path = "//*[@class='row']/div[1]/ul/li[" + (i+1) + "]/a";
            driver.findElement(By.xpath(path)).click();
            System.out.println(driver.findElement(By.xpath("//h3")).getText() + " --- " + footer.onlineStoreArray[i]);
            Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),footer.onlineStoreArray[i]);
            driver.navigate().back();
        }
    }

    @Test
    void fourWheelOffRoadLinkTest(){
        footer.fourWheelOffRoadLinkClick();
        Assert.assertEquals(driver.getTitle(), "Rifle 4 Wheel Off Road");
    }

    @Test
    void customManufacturingLinkTest(){
        footer.customManufacturingLinkClick();
        for (String tab: driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        Assert.assertEquals(driver.getTitle(), "Rifle Job Shop Atascadero, CA 93422-Vacuum Forming, CNC Machining");
    }

    @Test
    void mineColumnTest() {
        for (int i = 0; i < 6; i++) {
            driver.findElement(By.xpath("//*[@id='footerMiddle']/div/div[1]/div[1]/ul/li[" + (i+1) + "]/a")).click();
            Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), footer.mainColumnArray[i]);
        }
    }
}
