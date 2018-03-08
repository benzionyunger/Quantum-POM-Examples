package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.utils.DeviceUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class RentalOwnerDetailsPage extends AbstractBasePage {


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
    QAFWebElement DOB_month;

    @FindBy(locator = "ownerDetails.DOB-day.dropbox")
    QAFWebElement DOB_day;

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




    public RentalOwnerDetailsPage(){
        super();
    }
    public void validateRentalOwnerDetailsPage(){
        header.waitForPresent(5000);
    }


    public void addNewOwnerEntry(String newOwnerFirstName, String newOwnerSecondName,String year, String month, String day, String email,String phone_Number, String country, String state, String city, String street, String zip){

        firstName.sendKeys(newOwnerFirstName);
        lastName.sendKeys(newOwnerSecondName);
        DeviceUtils.swipe("50%,85%", "50%,25%");

        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("arguments[0].click();", DOB_day);
//        Select selectDay = new Select((this.driver).findElement(DOB_day.toString()));
//        selectDay.selectByVisibleText(day);
//        Select selectMonth = new Select((this.driver).findElement(DOB_month.toString()));
//        selectMonth.selectByVisibleText(month);
//        Select selectYear = new Select((this.driver).findElement(DOB_year.toString()));
//        selectYear.selectByVisibleText(year);
        emailBtn.click();
        emailField.sendKeys(email);
        phoneNumber.sendKeys(phone_Number);
        DeviceUtils.swipe("50%,85%", "50%,25%");
//        Select selectCountry = new Select((this.driver).findElement(Country.toString()));
//        selectCountry.selectByVisibleText(country);
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
