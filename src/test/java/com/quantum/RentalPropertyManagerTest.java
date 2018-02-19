package com.quantum;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import static com.quantum.pages.AbstractBasePage.Pages;
import static com.quantum.pages.LoginPage.*;
import com.quantum.pages.HomePage;
import com.quantum.pages.LoginPage;
import com.quantum.pages.RentalOwners;
import com.quantum.pages.Units;
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

    }

    @Test
    public void loginTest() {
        logStepStart("Browse to Login Page");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login(username,password);
        homePage.navapplicationsTenants();
        menuDropBox(Pages.PROPERTIES);
        logout();
    }

    @Test
    public void rentalOwnerTest(){
        logStepStart("Browse to Login Page");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login(username,password);
        RentalOwners rentalOwners = homePage.navRentalOwners();
        rentalOwners.clearOwner(owner);
        rentalOwners.addNewOwner(owner);
        if(rentalOwners.validateOwner(owner)){
            rentalOwners.clearOwner(owner);}
        logout();
    }

    @Test
    public void unitTest(){
        logStepStart("Browse to Login Page");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login(username,password);
        Units units = homePage.navUnits();
        units.clearUnit(unit);
        units.addNewUnit(unit);
        if(units.validateUnit(unit)){
            units.clearUnit(unit);
        }
        logout();

    }
}
