package model.menus;

import Utils.UtilsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Footer {

    WebDriver driver;
    public String[] footerLinks = {"Home", "Selecting a Windshield", "Order Info", "Become a Dealer", "Contact Us",
            "Learn About Rifle", "Custom Manufacturing", "BMW", "Buell", "Can-Am", "Harley-Davidson", "Honda",
            "Indian", "Kawasaki", "Moto-Guzzi", "Suzuki", "Triumph", "Victory", "Yamaha", "Just Released",
            "SoloShield Windshields", "Replacement Windshields", "Fairings", "Classic Windshields",
            "Classic L Windshields", "Classic SS Windshields", "Classic Lowers", "Other Products",
            "4 Wheel Off Road", "Cart", "Wishlist", "Account", "Login"};

    public String[] motoProductsArray = {"Just Released", "SoloShield Universal Windshields",
            "Motorcycle Replacement Windshields", "Fairings", "Classic Windshield", "Classic L Windshields",
            "Classic SS Windshield", "Classic Lowers", "Other Products"};

    public String[] onlineStoreArray = { "Motorcycle Windshields and Fairings", "How to Select a Windshield Size",
            "How To Order RIFLE Products", "Dealer Information Page" };

    public String[] mainColumnArray = { "Motorcycle Windshields and Fairings", "How to Select a Windshield Size",
            "How To Order RIFLE Products", "Dealer Information Page", "Contact RIFLE", "Message From The President"};

    public Footer(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (xpath = "//*[@id='footerMiddle']//*[contains(text(),'Main')]")
    public WebElement main;
    @FindBy (xpath = "//*[@id='footerMiddle']//*[contains(text(), 'Search By Make')]")
    public WebElement searchByMake;
    @FindBy (xpath = "//*[@id='footerMiddle']//*[contains(text(), 'Motorcycle Products')]")
    public WebElement motorcycleProducts;
    @FindBy (xpath = "//*[@id='footerMiddle']//*[contains(text(),'4 Wheel Offroad')]")
    public WebElement fourWheelOffRoad;
    @FindBy (xpath = "//*[@id='footerMiddle']//*[contains(text(),'Online Store')]")
    public WebElement onlineStore;
    @FindBy (id = "ctl00_ctl00_PageFooter_StoreFooter_FooterLinksAjax")
    public WebElement shortMenu;
    @FindBy (id = "ctl00_ctl00_NestedMaster_PageFooter_StoreFooterRifle_F_FourWheelLink")
    public WebElement fourWheelOffRoadLink;
    @FindBy (id = "ctl00_ctl00_NestedMaster_PageFooter_StoreFooterRifle_F_JobShopLink")
    public WebElement customManufacturingLink;


    public void footerViewTest(){
        UtilsMethod utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        utilsMethod.scroll(driver,main);
        List<WebElement> footerElements = driver.findElements(By.xpath("//ul//*[contains(@id,'PageFooter_StoreFooter')]"));
        for (int i = 0; i < footerElements.size(); i++) {
            Assert.assertTrue(footerElements.get(i).getText().equals(footerLinks[i]));
            System.out.println(footerElements.get(i).getText() + " ---- " + footerLinks[i]);
        }
        Assert.assertTrue(main.isDisplayed() && searchByMake.isDisplayed() && onlineStore.isDisplayed()
                && motorcycleProducts.isDisplayed() && fourWheelOffRoad.isDisplayed());
    }

    public void footerShortTest(){
        UtilsMethod utilsMethod = PageFactory.initElements(driver, UtilsMethod.class);
        utilsMethod.scroll(driver,shortMenu);
        Assert.assertTrue(shortMenu.isDisplayed());
    }

    public void fourWheelOffRoadLinkClick() { fourWheelOffRoadLink.click(); }
    public void customManufacturingLinkClick() { customManufacturingLink.click(); }
}
