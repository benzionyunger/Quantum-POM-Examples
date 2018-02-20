package com.quantum;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import static com.quantum.pages.AbstractBasePage.Pages;
import static com.quantum.pages.LoginPage.*;

import com.quantum.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static com.quantum.listerners.QuantumReportiumListener.logStepStart;
import static com.quantum.pages.AbstractBasePage.menuDropBox;

public class RentalPropertyManagerTest extends WebDriverTestCase {
    private String username = getBundle().getPropertyValue("demoOwnerUsername");
    private String password = getBundle().getPropertyValue("demoOwnerPassword");
    private String owner = getBundle().getPropertyValue("owner");
    private String unit = getBundle().getPropertyValue("unit");

    @BeforeTest
    public void beforeTest() {
        logStepStart("Open browser");
        getDriver().get(getBundle().getPropertyValue("env.baseurl"));
        new LoginPage();
        try {
            logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

    @Test(enabled = false)
    public void loginTest() {
        logStepStart("Browse to Login page");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login(username,password);
        homePage.navapplicationsTenants();
        menuDropBox(Pages.PROPERTIES);
        logout();
    }

    @Test(enabled = true)
    public void rentalOwnerTest(){
        logStepStart("Browse to Login page");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login(username,password);
        logStepStart("Navigate to Rental Owner page");
        RentalOwners rentalOwners = homePage.navRentalOwners();
        logStepStart("Enter new owner details");
        rentalOwners.clearOwner(owner);
        rentalOwners.addNewOwner(owner);
        if(rentalOwners.validateOwner(owner)){
            rentalOwners.clearOwner(owner);}
        logStepStart("Logout");
        logout();
    }

    @Test(enabled = false)
    public void unitTest(){
        logStepStart("Browse to Login page");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login(username,password);
        logStepStart("Navigate to Units page");
        Units units = homePage.navUnits();
        logStepStart("Enter new owner details");
        units.clearUnit(unit);
        units.addNewUnit(unit);
        if(units.validateUnit(unit)){
            units.clearUnit(unit);
        }
        logStepStart("Logout");
        logout();

    }
}
