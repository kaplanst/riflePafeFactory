package tests;

import Utils.BaseTest;
import model.MainPage;
import model.menus.Footer;
import model.menus.Header;
import model.menus.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    MainPage mainPage;

    @BeforeMethod
    void startTests() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    void mainPageHeaderTest(){
        Header header = PageFactory.initElements(driver, Header.class);
        header.headerTest();
    }

    @Test
    void menuMainPageTest() {
        TopMenu topMenu  = PageFactory.initElements(driver, TopMenu.class);
        topMenu.topMenuFullTest();
    }

    @Test
    void mainPageFootersTest (){
        Footer footer = PageFactory.initElements(driver, Footer.class);
        footer.footerViewTest();
    }

    @Test
    void fairingsPageTitleTest(){
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Motorcycle Windshields and Fairings");
    }

    @Test
    void fairingsLinkClickTest(){
        waitForElement(driver, mainPage.fairings);
        mainPage.fairingsClick();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Fairings");
    }

    @Test
    void replacementWindshieldsClickTest(){
        mainPage.replacementWindshieldsClick();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Motorcycle Replacement Windshields");
    }

    @Test
    void classicClickTest(){
        mainPage.classicClick();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Classic Windshields and Lowers");
    }

    @Test
    void soloShieldClickTest(){
        mainPage.soloShieldClick();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "SoloShield Universal Windshields");
    }

    @Test
    void justReleasedClickTest(){
        mainPage.justReleasedClick();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Just Released");
    }

    @Test
    void otherProductsClickTest(){
        mainPage.otherProductsClick();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Other Products");
    }
}
