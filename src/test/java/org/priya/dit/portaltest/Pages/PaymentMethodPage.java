package org.priya.dit.portaltest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.priya.dit.portaltest.Base.PortalBase;

public class PaymentMethodPage extends PortalBase {

   @FindBy(xpath = "//div[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
    WebElement paymentMethod;

    public PaymentMethodPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage choosePaymentMethodToProceed(){
        moveToElement(paymentMethod);
        paymentMethod.click();
        return PageFactory.initElements(driver, PaymentPage.class);
    }
}
