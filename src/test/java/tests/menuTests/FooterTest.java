package tests.menuTests;

import Utils.BaseTest;
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
        footer.headerFootersTest();
    }
}
