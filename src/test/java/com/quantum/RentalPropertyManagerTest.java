package com.quantum;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;

import com.quantum.pages.*;
import com.quantum.utils.DeviceUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static com.quantum.listerners.QuantumReportiumListener.logStepStart;

public class RentalPropertyManagerTest extends WebDriverTestCase {
    private final String USERNAME = getBundle().getPropertyValue("username");
    private final String PASSWORD = getBundle().getPropertyValue("password");
    private final String UNIT = getBundle().getPropertyValue("unit");
    private final String OWNER_FIRSTNAME = getBundle().getPropertyValue("ownerFirstName");
    private final String OWNER_LASTNAME = getBundle().getPropertyValue("ownerLastName");
    private final String COMPANY = getBundle().getPropertyValue("company");
    private final String MONTH = getBundle().getPropertyValue("month");
    private final String DAY = getBundle().getPropertyValue("day");
    private final String YEAR = getBundle().getPropertyValue("year");
    private final String EMAIL = getBundle().getPropertyValue("email");
    private final String COUNTRY = getBundle().getPropertyValue("country");
    private final String CITY = getBundle().getPropertyValue("city");
    private final String STREET = getBundle().getPropertyValue("street");
    private final String STATE = getBundle().getPropertyValue("state");
    private final String ZIP = getBundle().getPropertyValue("zip");
    private final String PHONE_NUMBER = getBundle().getPropertyValue("phoneNumber");

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @BeforeTest
    public void beforeTest() {
        logStepStart("Open browser");
        getDriver().get(getBundle().getPropertyValue("env.baseurl"));

    }

    /**
     * This test method checks if the user is logged into the web app, if he is then it logs out then logs in, otherwise just logs in.
     */
    @Test
    public void loginTest() {
        logStepStart("Browse to Login page");
        LoginPage loginPage = new LoginPage();
        if (!loginPage.isLoggedIn()) {
            loginPage.logout();
        }
        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        logStepStart("Validate successful login");
        homePage.validateUserLoggedIn(USERNAME);
    }

    /**
     * This test method logs into the web app, navigates and clicks on the Rental Owner's page, and processes a new entry.
     * First it checks if the entry currently exists, if it does it deletes the entry, then enters the new entry, and confirms
     * it was entered.
     */
    @Test
    public void addNewRentalOwnerTest(){
        logStepStart("Browse to Login page");
        LoginPage loginPage = new LoginPage();
        if (!loginPage.isLoggedIn()) {
            loginPage.logout();
        }
        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        logStepStart("Navigate to Rental Owner page");
        RentalOwnersPage rentalOwner = homePage.navigateRentalOwnersPage();
        logStepStart("Enter new owner details");
        rentalOwner.clearOwnerEntry(OWNER_FIRSTNAME, OWNER_LASTNAME);
        RentalOwnerDetailsPage rentalOwnerDetailsPage = rentalOwner.clickAddNew();
        rentalOwnerDetailsPage.validateRentalOwnerDetailsPage();
        rentalOwnerDetailsPage.addNewOwnerEntry(
                OWNER_FIRSTNAME,
                OWNER_LASTNAME,
                COMPANY,
                YEAR,
                MONTH,
                DAY,
                EMAIL,
                PHONE_NUMBER,
                COUNTRY,
                STATE,
                CITY,
                STREET,
                ZIP
        );
        DeviceUtils.waitForPresentTextVisual("the new record has been saved successfully",10);
        rentalOwnerDetailsPage.returnToRentalOwnersPage();
        logStepStart("Validate entry");
        DeviceUtils.swipe("50%,85%","50%,25%");
        Assert.assertTrue(rentalOwner.getValidation(OWNER_FIRSTNAME, OWNER_LASTNAME));
    }
}
