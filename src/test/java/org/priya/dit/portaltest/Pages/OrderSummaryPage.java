package org.priya.dit.portaltest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.priya.dit.portaltest.Base.PortalBase;

public class OrderSummaryPage extends PortalBase {

    @FindBy(xpath="//div[@id=\"center_column\"]/p[2]/a[1]")
    WebElement cartSummary;

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    public AddressPage verfifyAddressAndClickCheckout(){
        moveToElement(cartSummary);
        cartSummary.click();
        //clickable("cart_summary_proceed_to_checkout_xpath");
        return PageFactory.initElements(driver, AddressPage.class);
    }
}
