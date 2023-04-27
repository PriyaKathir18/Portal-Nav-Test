package org.priya.dit.portaltest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.priya.dit.portaltest.Base.PortalBase;

public class ProductPage extends PortalBase {

    @FindBy(id="color_8")
    WebElement pickColour;

    @FindBy(xpath="//span[contains(text(),'Add to cart')]")
    WebElement addToCart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPopUpPage chooseColourAndAddToCart(){
        pickColour.click();
        addToCart.click();
        return PageFactory.initElements(driver, ProductPopUpPage.class);
    }
}
