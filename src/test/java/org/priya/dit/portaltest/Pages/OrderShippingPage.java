package org.priya.dit.portaltest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.priya.dit.portaltest.Base.PortalBase;

public class OrderShippingPage extends PortalBase {

    @FindBy(id="cgv")
    WebElement checkTermsAndConditions;

    @FindBy(name ="processCarrier")
    WebElement proceedToCheckout;

    public OrderShippingPage(WebDriver driver) {
        super(driver);
    }

    public PaymentMethodPage acceptTermsAndProceedToCheckout(){
        checkTermsAndConditions.click();
        proceedToCheckout.click();
        return PageFactory.initElements(driver, PaymentMethodPage.class);
    }
}
