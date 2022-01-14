package tests.menuTests;

import Utils.BaseTest;
import model.menus.Footer;
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
    void headerFootersTest (){
        Assert.assertTrue(footer.main.isDisplayed() && footer.searchByMake.isDisplayed()
                    && footer.motorcycleProducts.isDisplayed() && footer.fourWheelOffroad.isDisplayed());
    }
}
