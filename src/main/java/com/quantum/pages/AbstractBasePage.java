package com.quantum.pages;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElementListHandler;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.utils.DeviceUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public abstract class AbstractBasePage extends WebDriverBaseTestPage<WebDriverTestPage> {

    @FindBy(locator = "base.signIn.text")
    private QAFWebElement signInText;
    @FindBy(locator = "base.menu.button")
    private QAFWebElement menuBtn;

    @FindBy(locator = "base.jumpTo.button")
    private QAFWebElement jumpToBtn;

    @FindBy(locator = "base.loginStatus.button")
    private QAFWebElement logoutBtn;

    private @FindBy(locator = "base.signedIn.button")
    QAFWebElement signedInBtn;

    @FindBy(locator = "base.signedIn.text")
    private QAFWebElement signedInUser;

    @FindBy(locator = "base.pageOptions.apps/leases.button")
    static QAFWebElement appsLeasesBtn;

    @FindBy(locator = "base.pageOptions.apps/tenants.button")
    static QAFWebElement appsTenantsBtn;

    @FindBy(locator = "base.pageOptions.properties.button")
    static QAFWebElement propertiesBtn;

    @FindBy(locator = "base.pageOptions.owners.button")
    static  QAFWebElement ownerBtn;

    @FindBy(locator = "base.pageOptions.units.button")
    static QAFWebElement unitsBtn;

    public enum Pages{
        APPLICATIONS(appsLeasesBtn),APPLICANTS(appsTenantsBtn),PROPERTIES(propertiesBtn),UNITS(unitsBtn),OWNERS(ownerBtn);
        public final QAFWebElement PAGE;
        Pages(QAFWebElement PAGE){
            this.PAGE = PAGE;
        }
    }


    public AbstractBasePage(){
        super();
    }
    public void validateUserLoggedIn(String username){
        username = username.toLowerCase();
        menuBtn.waitForEnabled(5000);
        menuBtn.click();
        Assert.assertEquals(username, signedInUser.getText());
    }
    public boolean isLoggedIn(){
        return signInText.isPresent();
    }

    public void logout(){
        menuBtn.click();
        logoutBtn.click();
    }

    public  void menuDropBox(Pages pages){
        menuBtn.click();
        jumpToBtn.click();
        pages.PAGE.click();
    }
}
