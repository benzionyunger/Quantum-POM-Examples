package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.utils.ConsoleUtils;
import com.quantum.utils.DeviceUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalOwnersPage extends AbstractBasePage {

    private QAFWebElement firstNameElement = null;

    @FindBy(locator = "base.addNew.Btn")
    private QAFWebElement addNew;

    @FindBy(locator = "owners.title")
    public QAFWebElement title;

    RentalOwnersPage(){
        super();
        validatePage();
    }

    private void validatePage(){
       title.waitForPresent(5000);
    }

    /**
     * Verifies if the new entry already exists on the owners list on the page, if it does exist, it deletes the entry.
     * @param ownerFirstName owner's first name
     * @param ownerLastName owner's second name
     */
    public void clearOwnerEntry(String ownerFirstName, String ownerLastName){
        DeviceUtils.swipe("50%,85%", "50%,25%");

        QAFWebElement newEntry = validateOwnerEntryExists(ownerFirstName, ownerLastName);
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
        addNew.waitForEnabled(5000);
        addNew.click();
        return new RentalOwnerDetailsPage();
    }

    public boolean getValidation(String ownerFirstName, String ownerLastName){
        return (validateOwnerEntryExists(ownerFirstName, ownerLastName)!= null);
    }

    /**
     * Iterates through the table rows, and checks if the first and last names in each row, match the new entry name.
     * @param ownerFirstName owner first name
     * @param ownerLastName owner last name
     * @return The web element of the matching name, in order to click and delete.
     */
    private QAFWebElement validateOwnerEntryExists(String ownerFirstName, String ownerLastName){
        try {
            List<WebElement> rowList = this.driver.findElementsByTagName("tr");
            for (int i = 1; i < rowList.size()-1; i++) {
                List<WebElement> columnList = rowList.get(i).findElements(By.tagName("td"));
                if (columnList.get(1).getText().equalsIgnoreCase(ownerFirstName) && columnList.get(2).getText().equalsIgnoreCase(ownerLastName)) {
                    ConsoleUtils.logInfoBlocks(ownerFirstName + " " + ownerLastName + " was found in the list");
                    WebElement e = columnList.get(1).findElement(By.tagName("a"));
                    firstNameElement = (QAFWebElement) e;
                    break;
                }
            }
        }catch (Exception e){
            ConsoleUtils.logInfoBlocks("There are no owner listings");
        }
            return firstNameElement;
    }

    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {
    }
}
