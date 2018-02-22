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

    @FindBy(locator = "base.addNew.Btn")
    private QAFWebElement addNew;

    @FindBy(locator = "owners.header.text")
    QAFWebElement header;

    public RentalOwners(){
        super();
        validatePage();
    }
    private void validatePage(){
       title.click();
    }
    public void clearOwnerEntry(String ownerFirstName,String ownerLastName){
        RentalOwnerDetails.TwoTypeReturn entry = new RentalOwnerDetails().validateOwnerEntryExists(ownerFirstName,ownerLastName);
        if(entry.exists)
            entry.correctEntry.click();
        RentalOwnerDetails rentalOwnerDetails = new RentalOwnerDetails();
        rentalOwnerDetails.delete.click();
        driver.switchTo().alert().accept();

    }
    public RentalOwnerDetails clickAddNew(){
        addNew.click();
        return new RentalOwnerDetails();
    }

    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }
}
