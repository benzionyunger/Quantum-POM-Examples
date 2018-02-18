package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import org.openqa.selenium.NoSuchElementException;

public class RentalOwners extends AbstractBasePage {
    private QAFExtendedWebDriver driver = new QAFExtendedWebDriver();

    @FindBy(locator = "owners.title")
    private QAFWebElement title;

    @FindBy(locator = "owners.delete.button")
    private QAFWebElement delete;

    @FindBy(locator = "base.addNew.Btn")
    private QAFWebElement addNew;

    @FindBy(locator = "base.save.btn")
    private QAFWebElement save;

    @FindBy(locator = "owners.firstName.field")
    QAFWebElement firstName;

    @FindBy(locator = "owners.lastName.field")
    QAFWebElement lastName;

    public RentalOwners(){
        super();
        validatePage();
    }
    private void validatePage(){
       title.click();
    }
    private Boolean validateOwner(String owner){
        try {
            driver.findElementByXPath("//*[text()="+owner+"\"]");
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
    public void clearOwner(String owner){
        boolean exists;
        if(validateOwner(owner)){
            exists=true;
            while(exists) {
                driver.findElementByXPath("//*[text()=" + owner + "\"]").click();
                delete.waitForPresent(3000);
                delete.click();
                driver.switchTo().alert().accept();
                exists = validateOwner(owner);
            }
        }
    }
    public void addNewOwner(String newOwner){
        addNew.click();
        firstName.sendKeys("");
        lastName.sendKeys("");
        save.click();

    }
    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }
}
