package org.priya.dit.portaltest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.priya.dit.portaltest.Base.PortalBase;
import org.priya.dit.portaltest.Pages.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PortalTest extends PortalBase {

    @BeforeTest
    public void setUp() {
        test = report.startTest(" Axone Portal Test", "Sign-in scenario Test");

        testLogInfo("Launcing the browser");
        launchBrowser();

        testLogInfo("Navigating to the Url");
        navigateToUrl();

        testLogInfo("Click on the Sign in link");
        clickable("find_signin_lnk_xpath");

        testLogInfo("Enter email id");
        enterValueInTextField("enter_email_txt_id", prop.getProperty("value_enter_email"));

        testLogInfo("Enter password");
        enterValueInTextField("enter_password_txt_name", prop.getProperty("value_enter_password"));

        testLogInfo("Click on sign in button");
        clickable("click_button_id");

    }


    @Test
    public void portalTest() throws InterruptedException {

        testLogInfo("HomePage");
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Thread.sleep(2000);

        testLogInfo("Navigate to new products on Homepage");
        NewProductsPage newProductsPage = homePage.moveToNewProductsAndClick();
        Thread.sleep(2000);

        testLogInfo("Click on blouse on products page");
        ProductPage productPage = newProductsPage.clickProductAndNavToProductPage();
        Thread.sleep(2000);

        testLogInfo("Added Products pop up ");
        ProductPopUpPage productPopUpPage = productPage.chooseColourAndAddToCart();
        Thread.sleep(2000);

        testLogInfo("Proceed to checkout");
        OrderSummaryPage orderSummaryPage = productPopUpPage.clickCheckoutToOrderSummaryPage();
        Thread.sleep(2000);

        testLogInfo("Verify cart and proceed to checkout");
        AddressPage addressPage = orderSummaryPage.verfifyAddressAndClickCheckout();
        Thread.sleep(2000);

        testLogInfo("Verify delivery address");
        OrderShippingPage orderShippingPage = addressPage.verifyAddressAndProceedToCheckout();
        Thread.sleep(2000);

        testLogInfo("Accept terms and conditions");
        PaymentMethodPage paymentMethodPage = orderShippingPage.acceptTermsAndProceedToCheckout();
        Thread.sleep(2000);

        testLogInfo("Choose the payment method");
        PaymentPage paymentPage = paymentMethodPage.choosePaymentMethodToProceed();
        Thread.sleep(2000);

        testLogInfo("Select the currency and confirm the order");
        OrderConfirmationPage orderConfirmationPage = paymentPage.selectCurrencyAndConfirmOrder();
        Thread.sleep(2000);

        testLogInfo("Check order history for order status");
        OrderHistoryPage orderHistoryPage = orderConfirmationPage.navToOrderHistoryPage();
        Thread.sleep(2000);
        orderHistoryPage.orderHistoryStatus();
        Thread.sleep(2000);

        testPassInfo("Successful scenario");
        //testFailInfo("Unsuccessful Scenario");

        //End Test
        report.endTest(test);

        //Writing to the log file
        report.flush();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {

        testLogInfo("Click on Sign out button");
        clickable("click_signout_button_linkText");
        Thread.sleep(2000);
        getDriver().quit();
    }
}

