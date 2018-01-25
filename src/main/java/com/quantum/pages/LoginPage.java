package com.quantum.pages;

import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.quantum.utils.DeviceUtils;

import static com.quantum.listerners.QuantumReportiumListener.logStepStart;

public class LoginPage extends AbstractBasePage{

    @FindBy(locator = "signIn.username.field")
    private QAFWebElement usernameField;
    @FindBy(locator = "signIn.password.field")
    private QAFWebElement passwordField;
    @FindBy(locator = "signIn.signIn.button")
    private QAFWebElement signInButton;

    public LoginPage(){
        super();
        validateLoginPage();
    }

    private void validateLoginPage(){
        DeviceUtils.waitForPresentTextVisual("Real Estate", 10);
    }

    public RealEstateHomePage login(String username, String password){
        logStepStart("User login: " + username);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signInButton.click();
        return new RealEstateHomePage();
    }
    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub
    }
}
