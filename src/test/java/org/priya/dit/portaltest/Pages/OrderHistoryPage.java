package org.priya.dit.portaltest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.priya.dit.portaltest.Base.PortalBase;

public class OrderHistoryPage extends PortalBase {

    @FindBy(xpath="//tbody/tr[1]/td[1]")
    WebElement orderReferenceStatus;

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    public void orderHistoryStatus(){
       orderReferenceStatus.click();
        }

}
