package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.utils.DeviceUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    public void returnToRentalOwnersPAge(){
        header.click();

    }
    private void validatePage(){
       title.waitForPresent(5000);
    }
    public void clearOwnerEntry(String ownerFirstName){
        DeviceUtils.swipe("50%,85%", "50%,25%");

        QAFWebElement newEntry = validateOwnerEntryExists(ownerFirstName);
        if(newEntry !=null){
            newEntry.click();
        RentalOwnerDetailsPage rentalOwnerDetailsPage = new RentalOwnerDetailsPage();
        rentalOwnerDetailsPage.validateRentalOwnerDetailsPage();
            Map<String, Object> params1 = new HashMap<>();
            params1.put("content", "Delete");
            params1.put("scrolling", "scroll");
            params1.put("next", "SWIPE_UP");
            this.driver.executeScript("mobile:text:find", params1);

            rentalOwnerDetailsPage.delete.click();
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "OK");
            this.driver.executeScript("mobile:button-text:click", params2);

        }

    }
    public RentalOwnerDetailsPage clickAddNew(){
        addNew.waitForPresent(5000);
        addNew.click();
        return new RentalOwnerDetailsPage();
    }
    public boolean getValidation(String ownerFirstName){
        return (validateOwnerEntryExists(ownerFirstName)!=null);
    }


    public QAFWebElement validateOwnerEntryExists(String ownerFirstName){

//        List<QAFWebElement> firstNameElementsList = (this.driver).findElements(firstNameColumn.toString());
//        List<QAFWebElement> lastNameElementsList = (this.driver).findElements(lastNameColumn.toString());
//
//        Iterator<QAFWebElement> iterator1 = firstNameElementsList.iterator();
//        Iterator<QAFWebElement> iterator2 = lastNameElementsList.iterator();
//        boolean exists = Boolean.parseBoolean(null);
//        QAFWebElement lastNameElement;
//        while (iterator1.hasNext() && iterator2.hasNext()) {
//            firstNameElement = iterator1.next();
//
//            lastNameElement = iterator2.next();
//            exists = firstNameElement.getText().equalsIgnoreCase(ownerFirstName) && lastNameElement.getText().equalsIgnoreCase(ownerLastName);
//            if (exists) {
//                break;
//            }else {
//                firstNameElement = null;
//            }
//        }
//        System.out.println("Both elements exist:" + String.valueOf(exists));
        try {
            firstNameElement = this.driver.findElementByLinkText(ownerFirstName);
//            firstNameElement = (this.driver).findElement("//*[text()=\""+ownerFirstName+"\"]");
        } catch (Exception e) {
            System.out.println(ownerFirstName + " was not found in the owner's list");
        }
        return firstNameElement;
    }

    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }
}
