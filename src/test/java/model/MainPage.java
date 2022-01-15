package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    WebDriver driver;

    @FindBy (xpath = "//p[@class='categories-label'][contains(text(), 'Fairings')]/..")
    public WebElement fairings;
    @FindBy (xpath = "//p[@class='categories-label'][contains(text(), 'Replacement Windshields')]/..")
    public WebElement replacementWindshields;
    @FindBy (xpath = "//p[@class='categories-label'][contains(text(), 'Classic Cruiser Windshields and Lowers')]/..")
    public WebElement classic;
    @FindBy (xpath = "//p[@class='categories-label'][contains(text(), 'SoloShield Handlebar Mount Windshields')]/..")
    public WebElement soloShield;
    @FindBy (xpath = "//p[@class='categories-label'][contains(text(), 'Just Released')]/..")
    public WebElement justReleased;
    @FindBy (xpath = "//p[@class='categories-label'][contains(text(), 'Other Rifle Products')]/..")
    public WebElement otherProducts;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fairingsClick(){ fairings.click(); }
    public void replacementWindshieldsClick(){ replacementWindshields.click(); }
    public void classicClick(){ classic.click(); }
    public void soloShieldClick(){ soloShield.click(); }
    public void justReleasedClick(){ justReleased.click(); }
    public void otherProductsClick(){ otherProducts.click(); }

}
