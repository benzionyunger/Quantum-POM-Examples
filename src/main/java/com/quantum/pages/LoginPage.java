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
    @FindBy(locator = "login.title")
    private QAFWebElement title;

    public LoginPage(){
        super();
        validateLoginPage();
    }

    private void validateLoginPage(){
        title.waitForPresent(5000);
    }

    public HomePage login(String username, String password){
        logStepStart("User login: " + username);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signInButton.click();
        return new HomePage();
    }
    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub
    }
}
