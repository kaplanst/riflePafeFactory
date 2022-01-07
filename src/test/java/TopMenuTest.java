import Utils.BaseTest;
import model.LoginPage;
import model.MainPage;
import model.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {

    TopMenu topMenu;

    @BeforeMethod
    void startTests() {
        topMenu = PageFactory.initElements(driver, TopMenu.class);
    }

    @Test
    void clickHomeLinkTest(){
        topMenu.clickHomeLink();
    }

    @Test
    void clickSearchByModelsLinkTest(){
        topMenu.clickSearchByModelsLink();
        Assert.assertEquals(driver.getTitle(), "Search for Rifle Products by Make Model");
    }

    @Test
    void clickContactRifleLinkTest(){
        topMenu.clickContactRifleLink();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Contact RIFLE");
    }

    @Test
    void clickAboutAsLinkTest(){
        topMenu.clickAboutAsLink();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Message From The President");
    }

    @Test
    void checkProductsDropDownTest() {
        topMenu.checkProductsDropDown();
    }


}
