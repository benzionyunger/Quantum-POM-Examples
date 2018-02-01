package com.quantum;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import static com.quantum.pages.AbstractBasePage.Pages;
import static com.quantum.pages.LoginPage.*;
import com.quantum.pages.HomePage;
import com.quantum.pages.LoginPage;
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
        logStepStart("Browse to Login Page");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login(getBundle().getPropertyValue("demoOwnerUsername"),getBundle().getPropertyValue("demoOwnerPassword"));
        homePage.navapplicationsTenants();
        menuDropBox(Pages.PROPERTIES);
        logout();

    }
}
