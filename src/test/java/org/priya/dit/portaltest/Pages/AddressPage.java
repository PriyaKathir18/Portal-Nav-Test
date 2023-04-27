package org.priya.dit.portaltest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.priya.dit.portaltest.Base.PortalBase;

public class AddressPage extends PortalBase {

    @FindBy(name="processAddress")
    WebElement verifyAddress;

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public OrderShippingPage verifyAddressAndProceedToCheckout(){
        moveToElement(verifyAddress);
        verifyAddress.click();
       // clickable("process_address_checkout_name");
        return PageFactory.initElements(driver,OrderShippingPage.class);
    }
}
