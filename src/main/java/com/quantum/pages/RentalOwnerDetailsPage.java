package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class RentalOwnerDetailsPage extends AbstractBasePage {
    private QAFExtendedWebDriver driver = new QAFExtendedWebDriver();
    private QAFWebElement firstNameElement = null;


    @FindBy(locator = "ownersDetails.header.text")
    private QAFWebElement header;

    @FindBy(locator = "base.delete.button")
    protected QAFWebElement delete;

    @FindBy(locator = "ownerDetails.firstName.field")
    private QAFWebElement firstName;

    @FindBy(locator = "ownerDetails.lastName.field")
    private QAFWebElement lastName;

    @FindBy(locator = "base.save.btn")
    private QAFWebElement save;

    @FindBy(locator = "ownerDetails.DOB-month.dropbox")
    QAFWebElement DOB_day;

    @FindBy(locator = "ownerDetails.DOB-day.dropbox")
    QAFWebElement DOB_month;

    @FindBy(locator = "ownerDetails.DOB-year.dropbox")
    QAFWebElement DOB_year;

    @FindBy(locator = "ownerDetails.email.button")
    QAFWebElement emailBtn;

    @FindBy(locator = "ownerDetails.email.field")
    QAFWebElement emailField;

    @FindBy(locator = "ownerDetails.phone.field")
    QAFWebElement phoneNumber;

    @FindBy(locator = "ownerDetails.country.dropbox")
    QAFWebElement Country;

    @FindBy(locator = "ownerDetails.state.dropbox")
    QAFWebElement State;

    @FindBy(locator = "ownerDetails.street.field")
    QAFWebElement Street;

    @FindBy(locator = "ownerDetails.city.field")
    QAFWebElement City;

    @FindBy(locator = "ownerDetails.zip.field")
    QAFWebElement Zip;

    @FindBy(locator = "owners.firstNameColumn.text")
    QAFWebElement firstNameColumn;

    @FindBy(locator = "owners.lastNameColumn.text")
    QAFWebElement lastNameColumn;


    public RentalOwnerDetailsPage(){
        super();
        validateRentalOwnerDetailsPage();
    }
    public void validateRentalOwnerDetailsPage(){
        header.waitForPresent(5000);
    }
    public QAFWebElement validateOwnerEntryExists(String ownerFirstName, String ownerLastName){

            header.click();
            List<QAFWebElement> firstNameElementsList = driver.findElements(firstNameColumn.toString());
            List<QAFWebElement> lastNameElementsList = driver.findElements(lastNameColumn.toString());
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
    public boolean getValidation(String ownerFirstName,String ownerLastName){
        return (validateOwnerEntryExists(ownerFirstName,ownerLastName)!=null);
    }

    public void addNewOwnerEntry(String newOwnerFirstName, String newOwnerSecondName,String year, String month, String day, String email,String phone_Number, String country, String state, String city, String street, String zip){

        firstName.sendKeys(newOwnerFirstName);
        lastName.sendKeys(newOwnerSecondName);
        Select selectDay = new Select(driver.findElement(DOB_day.toString()));
        selectDay.selectByVisibleText(day);
        Select selectMonth = new Select(driver.findElement(DOB_month.toString()));
        selectMonth.selectByVisibleText(month);
        Select selectYear = new Select(driver.findElement(DOB_year.toString()));
        selectYear.selectByVisibleText(year);
        emailBtn.click();
        emailField.sendKeys(email);
        phoneNumber.sendKeys(phone_Number);
        Select selectCountry = new Select(driver.findElement(Country.toString()));
        selectCountry.selectByVisibleText(country);
        State.sendKeys(state);
        City.sendKeys(city);
        Street.sendKeys(street);
        Zip.sendKeys(zip);
        save.click();
    }

    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }
}
