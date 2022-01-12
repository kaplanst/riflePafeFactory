package model.menus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TopMenu {
    public TopMenu(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    @FindBy(id = "ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootNavHomeLink")
    public WebElement homeLink;

    @FindBy(id = "ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootNavSearchModelLink")
    public WebElement searchByModelsLink;

    @FindBy(id = "ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootNavContactLink")
    public WebElement contactRifleLink;

    @FindBy(xpath = "//*[@id='cssmenu']/ul/li[1]")
    public WebElement productsDropDown;

    @FindBy(xpath = "//*[@id='cssmenu']/ul/li[2]")
    public WebElement infoDropDown;

    @FindBy(xpath = "//a[@href='/About-Us.aspx']")
    public WebElement aboutAsLink;

    @FindBy(xpath = "//*[@id='cssmenu']//*[contains(text(),'Windshield Selection Guide')]")
    public WebElement windshieldSelectionGuide;

    @FindBy(xpath = "//*[@id='cssmenu']//*[contains(text(),'Order Info')]")
    public WebElement orderInfo;

    @FindBy(xpath = "//*[@id='cssmenu']//*[contains(text(),'Become a Dealer')]")
    public WebElement becomeDealer;

    @FindBy(xpath = "//*[@id='cssmenu']//*[contains(text(),'Inquire About Custom Manufacturing')]")
    public WebElement inquireAboutCustomManufacturing;

    @FindBy(xpath = "//*[@id='cssmenu']//*[contains(text(),'Just Released')]")
    public WebElement justReleasedLink;

    @FindBy(id = "ctl00_ctl00_PageHeader_StoreHeader_BootNavHomeLink")
    public WebElement shortHomeLink;

    @FindBy(id = "ctl00_ctl00_PageHeader_StoreHeader_BootNavContactLink")
    public WebElement contactUsLink;

    public void clickHomeLink(){homeLink.click();}
    public void clickSearchByModelsLink(){searchByModelsLink.click();}
    public void clickContactRifleLink(){contactRifleLink.click();}
    public void clickAboutAsLink(){aboutAsLink.click();}
    public void clickWindshieldSelectionGuide(){windshieldSelectionGuide.click();}
    public void clickOrderInfo(){orderInfo.click();}
    public void clickBecomeDealer(){becomeDealer.click();}
    public void clickInquireAboutCustomManufacturing(){inquireAboutCustomManufacturing.click();}

    public void clickItem(String item) {
        driver.findElement(By.xpath("//*[@id='cssmenu']//*[contains(text(),'" + item + "')]")).click();
    }

    public TopMenu checkProductsDropDown(String item){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By
                .xpath("//*[@id='cssmenu']//*[contains(text(),'" + item + "')]"))).build().perform();
        return this;
    }
    public TopMenu checkInfoDropDown(){
        Actions actions = new Actions(driver);
        actions.moveToElement(infoDropDown).build().perform();
        return this;
    }
}