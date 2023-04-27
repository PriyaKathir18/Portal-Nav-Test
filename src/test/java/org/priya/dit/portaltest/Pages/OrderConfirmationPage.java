package org.priya.dit.portaltest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.priya.dit.portaltest.Base.PortalBase;

public class OrderConfirmationPage extends PortalBase {

    @FindBy(xpath = "//div[@id=\"center_column\"]/p[2]/a")
    WebElement orderHistory;
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public OrderHistoryPage navToOrderHistoryPage(){
        orderHistory.click();
        return PageFactory.initElements(driver, OrderHistoryPage.class);
    }
}
