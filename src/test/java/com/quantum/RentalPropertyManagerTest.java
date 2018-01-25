package com.quantum;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.pages.LoginPage;
import com.quantum.utils.DeviceUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static com.quantum.listerners.QuantumReportiumListener.logStepStart;

public class RentalPropertyManagerTest extends WebDriverTestCase {

    @BeforeTest
    public void beforeTest() {

        logStepStart("Open browser");

        DeviceUtils.switchToContext("WEBVIEW");

        getDriver().get(getBundle().getPropertyValue("env.baseurl"));

//        getDriver().manage().deleteAllCookies();

    }

    @Test
    public void loginTest() {
        logStepStart("Browse to Login Page");
        DeviceUtils.switchToContext("WEBVIEW");
        LoginPage loginPage = new LoginPage();
        loginPage.login(getBundle().getPropertyValue("demoOwnerUsername"),getBundle().getPropertyValue("demoOwnerPassword"));

    }
}
