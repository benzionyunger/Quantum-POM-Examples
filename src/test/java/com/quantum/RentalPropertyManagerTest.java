package com.quantum;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;

import com.quantum.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static com.quantum.listerners.QuantumReportiumListener.logStepStart;

public class RentalPropertyManagerTest extends WebDriverTestCase {
    private final String USERNAME = getBundle().getPropertyValue("username");
    private final String PASSWORD = getBundle().getPropertyValue("password");
    private final String OWNER_FIRSTNAME = getBundle().getPropertyValue("ownerFirstName");
    private final String OWNER_LASTNAME = getBundle().getPropertyValue("ownerLastName");
    private final String MONTH = getBundle().getPropertyValue("month");
    private final String UNIT = getBundle().getPropertyValue("unit");

    @BeforeTest
    public void beforeTest() {
        logStepStart("Open browser");
        getDriver().get(getBundle().getPropertyValue("env.baseurl"));
        LoginPage loginPage = new LoginPage();
        if (loginPage.isLoggedIn()) {
            loginPage.logout();
        }
    }
    @Test(enabled = false)
    public void loginTest() {
        logStepStart("Browse to Login page");
        LoginPage loginPage = new LoginPage();
        loginPage.validateLoginPage();
        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        homePage.validateUserLoggedIn(USERNAME);
    }

    @Test(enabled = true)
    public void addNewRentalOwnerTest(){
        logStepStart("Browse to Login page");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        logStepStart("Navigate to Rental Owner page");
        RentalOwners rentalOwners = homePage.navigateRentalOwnersPage();
        logStepStart("Enter new owner details");
        rentalOwners.clearOwnerEntry(OWNER_FIRSTNAME);
        rentalOwners.addNewOwnerEntry(OWNER_FIRSTNAME,OWNER_LASTNAME);
        rentalOwners.validateOwnerEntryExists(OWNER_FIRSTNAME);
    }

    @Test(enabled = false)
    public void addNewUnitTest(){
        logStepStart("Browse to Login page");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        logStepStart("Navigate to Units page");
        Units units = homePage.navUnits();
        logStepStart("Enter new owner details");
        units.clearUnit(UNIT);
        units.addNewUnit(UNIT, MONTH);
        if(units.validateUnit(UNIT)){
            units.clearUnit(UNIT);
        }
        }
}
