package org.priya.dit.portaltest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.priya.dit.portaltest.Base.PortalBase;

public class ProductPopUpPage extends PortalBase {

    @FindBy(xpath="//div[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement proceedToOrderSummary;

    public ProductPopUpPage(WebDriver driver) {
        super(driver);
    }

    public OrderSummaryPage clickCheckoutToOrderSummaryPage(){
        proceedToOrderSummary.click();
        return PageFactory.initElements(driver, OrderSummaryPage.class);
    }
}
