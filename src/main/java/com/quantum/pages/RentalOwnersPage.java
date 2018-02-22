package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class RentalOwnersPage extends AbstractBasePage {
    private QAFExtendedWebDriver driver = new QAFExtendedWebDriver();

    @FindBy(locator = "owners.title")
    private QAFWebElement title;

    @FindBy(locator = "base.addNew.Btn")
    private QAFWebElement addNew;

    @FindBy(locator = "owners.header.text")
    QAFWebElement header;

    public RentalOwnersPage(){
        super();
        validatePage();
    }
    private void validatePage(){
       title.click();
    }
    public void clearOwnerEntry(String ownerFirstName,String ownerLastName){
        QAFWebElement newEntry = new RentalOwnerDetailsPage().validateOwnerEntryExists(ownerFirstName,ownerLastName);
        if(newEntry !=null)
            newEntry.click();
        RentalOwnerDetailsPage rentalOwnerDetailsPage = new RentalOwnerDetailsPage();
        rentalOwnerDetailsPage.delete.click();
        driver.switchTo().alert().accept();

    }
    public RentalOwnerDetailsPage clickAddNew(){
        addNew.click();
        return new RentalOwnerDetailsPage();
    }

    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }
}
