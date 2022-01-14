package model.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer {

    WebDriver driver;

    public Footer(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (xpath = "//*[@id='footerMiddle']//*[contains(text(),'Main')]")
    WebElement main;
    @FindBy (xpath = "//*[@id='footerMiddle']//*[contains(text(), 'Search By Make')]")
    WebElement searchByMake;
    @FindBy (xpath = "//*[@id='footerMiddle']//*[contains(text(), 'Motorcycle Products')]")
    WebElement motorcycleProducts;
    @FindBy (xpath = "//*[@id='footerMiddle']//*[contains(text(),'4 Wheel Offroad')]")
    WebElement forWheelOffroad;
    @FindBy (xpath = "//*[@id='footerMiddle']//*[contains(text(),'Online Store')]")
    WebElement onlineStore;
    //*[contains(@id, 'PageFooter_StoreFooterRifle_F')]



}
