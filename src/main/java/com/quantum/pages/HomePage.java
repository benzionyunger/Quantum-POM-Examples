package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import java.util.HashMap;
import java.util.Map;

import static com.quantum.utils.DriverUtils.getDriver;

public class HomePage extends AbstractBasePage {
    @FindBy(locator = "home.apps/leases.button")
    private QAFWebElement appLeaseBtn;

    @FindBy(locator = "home.apps/tenants.button")
    private QAFWebElement appTenantsBtn;

    @FindBy(locator = "home.properties.button")
    private QAFWebElement propertiesBtn;

    @FindBy(locator = "home.units.button")
    private QAFWebElement unitsBtn;

    @FindBy(locator = "home.rentalOwners.button")
    private QAFWebElement rentalOwnersBtn;

    @FindBy(locator = "home.title")
    private QAFWebElement title;

    /**
     * Inherits driver and validates the home page loaded properly upon instantiation.
     */
    HomePage(){
        super();
        validateHomePage();
    }
    private void validateHomePage(){
        title.waitForPresent(5000);
    }

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub
    }

    /**
     * Smart scroll to desired page link.
     * @return RentalOwnersPage instantiation and validation.
     */
    public RentalOwnersPage navigateRentalOwnersPage(){
        Map<String, Object> params = new HashMap<>();
        params.put("content", "Rental");
        params.put("scrolling", "scroll");
        params.put("next", "SWIPE_UP");
        getDriver().executeScript("mobile:checkpoint:text", params);
        rentalOwnersBtn.click();
        return new RentalOwnersPage();
    }
}
