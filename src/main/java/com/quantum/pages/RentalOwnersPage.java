package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.utils.DeviceUtils;

import java.util.Iterator;
import java.util.List;

public class RentalOwnersPage extends AbstractBasePage {
    private QAFWebElement firstNameElement = null;

    @FindBy(locator = "owners.title")
    private QAFWebElement title;

    @FindBy(locator = "base.addNew.Btn")
    private QAFWebElement addNew;

    @FindBy(locator = "owners.header.text")
    QAFWebElement header;

    @FindBy(locator = "owners.firstNameColumn.text")
    QAFWebElement firstNameColumn;

    @FindBy(locator = "owners.lastNameColumn.text")
    QAFWebElement lastNameColumn;

    public RentalOwnersPage(){
        super();
        validatePage();
    }
    private void validatePage(){
       title.waitForPresent(5000);
    }
    public void clearOwnerEntry(String ownerFirstName,String ownerLastName){
        QAFWebElement newEntry = validateOwnerEntryExists(ownerFirstName,ownerLastName);
        if(newEntry !=null){
            newEntry.click();
        RentalOwnerDetailsPage rentalOwnerDetailsPage = new RentalOwnerDetailsPage();
        rentalOwnerDetailsPage.delete.click();

        driver.switchTo().alert().accept();}

    }
    public RentalOwnerDetailsPage clickAddNew(){
        addNew.click();
        return new RentalOwnerDetailsPage();
    }
    public boolean getValidation(String ownerFirstName,String ownerLastName){
        return (validateOwnerEntryExists(ownerFirstName,ownerLastName)!=null);
    }

    public QAFWebElement validateOwnerEntryExists(String ownerFirstName, String ownerLastName){

        List<QAFWebElement> firstNameElementsList = (this.driver).findElements(firstNameColumn.toString());
        List<QAFWebElement> lastNameElementsList = (this.driver).findElements(lastNameColumn.toString());

//        List<QAFWebElement> firstNameElementsList = driver.findElements(firstNameColumn.toString());
//        List<QAFWebElement> lastNameElementsList = driver.findElements(lastNameColumn.toString());
        Iterator<QAFWebElement> iterator1 = firstNameElementsList.iterator();
        Iterator<QAFWebElement> iterator2 = lastNameElementsList.iterator();
        boolean exists;
        QAFWebElement lastNameElement;
        while (iterator1.hasNext() && iterator2.hasNext()) {
            firstNameElement = iterator1.next();
            lastNameElement = iterator2.next();
            exists = firstNameElement.getText().equalsIgnoreCase(ownerFirstName) && lastNameElement.getText().equalsIgnoreCase(ownerLastName);
            if (exists) {
                break;
            }else {
                firstNameElement = null;
            }
        }
        return firstNameElement;
    }

    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }
}
