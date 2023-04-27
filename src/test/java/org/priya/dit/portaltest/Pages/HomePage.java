package org.priya.dit.portaltest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.priya.dit.portaltest.Base.PortalBase;

public class HomePage extends PortalBase {

    @FindBy(xpath = "//a[contains(text(),'New products')]")
    WebElement newProducts;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public NewProductsPage moveToNewProductsAndClick() {
        moveToElement(newProducts);
        newProducts.click();
        return PageFactory.initElements(driver, NewProductsPage.class);

    }
}
