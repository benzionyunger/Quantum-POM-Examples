package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.utils.DeviceUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class RentalOwnerDetailsPage extends AbstractBasePage {


    @FindBy(locator = "ownersDetails.header.text")
    private QAFWebElement formHeader;

    @FindBy(locator = "ownersDetails.pageHeader.text")
    private QAFWebElement pageHeader;

    @FindBy(locator = "base.delete.button")
    protected QAFWebElement delete;

    @FindBy(locator = "ownerDetails.firstName.field")
    private QAFWebElement firstName;

    @FindBy(locator = "ownerDetails.lastName.field")
    private QAFWebElement lastName;

    @FindBy(locator = "base.save.btn")
    private QAFWebElement save;

    @FindBy(locator = "ownerDetails.state.dropbox")
    QAFWebElement stateArrowBtn;

    @FindBy(locator = "ownerDetails.state.searchbox.field")
    QAFWebElement stateSearchBox;

    @FindBy(locator = "ownerDetails.stateMatch.text")
    QAFWebElement stateMatch;

    @FindBy(locator = "ownerDetails.email.button")
    QAFWebElement emailBtn;

    @FindBy(locator = "ownerDetails.email.field")
    QAFWebElement emailField;

    @FindBy(locator = "ownerDetails.phone.field")
    QAFWebElement phoneNumber;

    @FindBy(locator = "ownerDetails.country.dropbox")
    QAFWebElement Country;

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
        formHeader.waitForPresent(20000);
    }

    public RentalOwnersPage returnToRentalOwnersPage(){
        pageHeader.click();
        return new RentalOwnersPage();
    }
    public void addNewOwnerEntry(String newOwnerFirstName, String newOwnerSecondName,String year, String month, String day, String email,String phone_Number, String country, String state, String city, String street, String zip){

        firstName.sendKeys(newOwnerFirstName);
        lastName.sendKeys(newOwnerSecondName);
        DeviceUtils.swipe("50%,85%", "50%,25%");
        this.driver.findElement("//*[text()=\""+month+"\"]").click();
        this.driver.findElement("//*[text()=\""+year+"\"]").click();
        this.driver.findElement("//*[text()=\""+day+"\"]").click();
        emailBtn.click();
        emailField.sendKeys(email);
        phoneNumber.sendKeys(phone_Number);
        DeviceUtils.swipe("50%,85%", "50%,25%");
        this.driver.findElement("//*[text()=\""+country+"\"]").click();
        stateArrowBtn.click();
        stateSearchBox.sendKeys(state);
        stateMatch.click();
        City.sendKeys(city);
        Street.sendKeys(street);
        Zip.sendKeys(zip);
        DeviceUtils.swipe("50%,85%", "50%,25%");

        save.click();
    }

    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }
}
