package model;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage {
    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    @FindBy (xpath = "//input[@value='+ Add to Cart']")
    WebElement addToCartButton;
    @FindBy (xpath = "//h1")
    WebElement header;


    public ItemPage clickAddToCartButton(){
        addToCartButton.click();
        return this;
    }
    public String getHeaderText (){
        return header.getText();
    }


}
