package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TopMenu {
    public TopMenu(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    @FindBy(id = "ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootNavHomeLink")
    WebElement homeLink;

    @FindBy(id = "ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootNavSearchModelLink")
    WebElement searchByModelsLink;

    @FindBy(id = "ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootNavContactLink")
    WebElement contactRifleLink;

    @FindBy(xpath = "//*[@id='cssmenu']/ul/li[1]")
    WebElement productsDropDown;

    @FindBy(xpath = "//*[@id='cssmenu']/ul/li[2]")
    WebElement infoDropDown;

    @FindBy(xpath = "//a[@href='/About-Us.aspx']")
    WebElement aboutAsLink;

    public void clickHomeLink(){homeLink.click();}
    public void clickSearchByModelsLink(){searchByModelsLink.click();}
    public void clickContactRifleLink(){contactRifleLink.click();}
    public void clickAboutAsLink(){aboutAsLink.click();}

    public void checkProductsDropDown(){
        Actions actions = new Actions(driver);
        actions.moveToElement(productsDropDown).build().perform();
    }


}
