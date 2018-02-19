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

    @BeforeTest
    public void beforeTest() {

        logStepStart("Open browser");

        getDriver().get(getBundle().getPropertyValue("env.baseurl"));

    }

    @Test
    public void loginTest() {
        String username = getBundle().getPropertyValue("demoOwnerUsername");
        String password = getBundle().getPropertyValue("demoOwnerPassword");
        logStepStart("Browse to Login Page");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login(username,password);
        homePage.navapplicationsTenants();
        menuDropBox(Pages.PROPERTIES);
        logout();
    }

    @Test
    public void rentalOwnerTest(){
        String owner = getBundle().getPropertyValue("owner");
        String username = getBundle().getPropertyValue("demoOwnerUsername");
        String password = getBundle().getPropertyValue("demoOwnerPassword");
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
}
