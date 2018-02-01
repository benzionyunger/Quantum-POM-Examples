package com.quantum.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElementListHandler;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractBasePage extends WebDriverBaseTestPage<WebDriverTestPage> {

    @FindBy(locator = "base.menu.button")
    private static QAFWebElement menuBtn;

    @FindBy(locator = "base.jumpTo.button")
    private static QAFWebElement jumpToBtn;

    @FindBy(locator = "base.loginStatus.button")
    private static QAFWebElement logoutBtn;

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

    public static void logout(){
        menuBtn.click();
        logoutBtn.click();}
    public static void menuDropBox(Pages pages){
        menuBtn.click();
        jumpToBtn.click();
        pages.PAGE.click();

    }
}
