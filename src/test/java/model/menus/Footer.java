package model.menus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    public void headerFootersTest (){
        List<WebElement> footerElements = driver.findElements(By.xpath("//ul//*[contains(@id,'PageFooter_StoreFooter')]"));
        for (int i = 0; i < footerElements.size(); i++) {
            Assert.assertTrue(footerElements.get(i).getText().equals(footerLinks[i]));
            System.out.println(footerElements.get(i).getText() + " ----" + footerLinks[i]);
        }
        Assert.assertTrue(main.isDisplayed() && searchByMake.isDisplayed() && onlineStore.isDisplayed()
                && motorcycleProducts.isDisplayed() && fourWheelOffRoad.isDisplayed());
    }

}
