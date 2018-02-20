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

    @FindBy(locator = "base.delete.button")
    private QAFWebElement delete;

    @FindBy(locator = "base.addNew.Btn")
    private QAFWebElement addNew;

    @FindBy(locator = "base.save.btn")
    private QAFWebElement save;

    @FindBy(locator = "owners.firstName.field")
    private QAFWebElement firstName;

    @FindBy(locator = "owners.lastName.field")
    private QAFWebElement lastName;

    public RentalOwners(){
        super();
        validatePage();
    }
    private void validatePage(){
       title.click();
    }
    public Boolean validateOwnerEntryExists(String owner){
        try {
            driver.findElementByXPath("//*[text()=\""+owner+"\"]");
        } catch (NoSuchElementException e) {
            System.out.println(owner+" owner was not found");
                    return false;
        }
        return true;
    }
    public void clearOwnerEntry(String owner){
            while(validateOwnerEntryExists(owner)) {
                driver.findElementByXPath("//*[text()=" + owner + "\"]").click();
                delete.waitForPresent(3000);
                delete.click();
                driver.switchTo().alert().accept();
        }
    }
    public void addNewOwnerEntry(String newOwnerFirstName, String newOwnerSecondName){
        addNew.click();
        firstName.sendKeys(newOwnerFirstName);
        lastName.sendKeys(newOwnerSecondName);

        save.click();

    }
    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }
}
