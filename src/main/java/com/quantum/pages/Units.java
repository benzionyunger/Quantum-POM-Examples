package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class Units extends AbstractBasePage {
    @FindBy(locator = "units.title")
    private QAFWebElement title;

    public Units(){
        super();
        validateUnitsPage();
    }

    public void clearUnit(){
    }
    private void validateUnitsPage(){title.click();}

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto
    }
}
