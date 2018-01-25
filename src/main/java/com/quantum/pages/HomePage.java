package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.utils.DeviceUtils;

public class HomePage extends AbstractBasePage {

    @FindBy(locator = "home.apps/leases.button")
    QAFWebElement appLeaseBtn;

    @FindBy(locator = "home.apps/tenants.button")
    QAFWebElement appTenantsBtn;

    @FindBy(locator = "home.properties.button")
    QAFWebElement propertiesBtn;

    @FindBy(locator = "home.units.button")
    QAFWebElement unitsBtn;

    @FindBy(locator = "home.rentalOwners.button")
    QAFWebElement rentalOwnersBtn;

    public HomePage(){
        super();
        validateHomePage();
    }
    private void validateHomePage(){
        DeviceUtils.waitForPresentTextVisual("Applications", 10);
    }

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub

    }
    
    public void navApplicationsLeases(){
        appLeaseBtn.click();
    }
    public void navapplicationsTenants(){
        appTenantsBtn.click();
    }
    public void navProperties(){
        propertiesBtn.click();
    }
    public void navUnits(){
        unitsBtn.click();
    }
    public void navRentalOwners(){
        rentalOwnersBtn.click();
    }
}
