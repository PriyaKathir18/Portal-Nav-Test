package org.priya.dit.portaltest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.priya.dit.portaltest.Base.PortalBase;

public class PaymentPage extends PortalBase {

   @FindBy(id="uniform-currency_payment")
    WebElement currency;

   @FindBy(xpath = "//p[@id=\"cart_navigation\"]/button")
   WebElement orderConfirmation;


   public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public OrderConfirmationPage selectCurrencyAndConfirmOrder(){
       //Select dropDown = new Select(currency);
       //dropDown.selectByIndex(1);
        currency.equals("Pound");
        orderConfirmation.click();
        //clickable(prop.getProperty("order_confirmation_xpath"));
       return PageFactory.initElements(driver, OrderConfirmationPage.class);
    }

}
