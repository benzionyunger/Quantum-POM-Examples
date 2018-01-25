package com.quantum.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public abstract class AbstractBasePage extends WebDriverBaseTestPage<WebDriverTestPage> {

    @FindBy(locator = "base.pageTitle")
    private QAFWebElement title;

    public AbstractBasePage(){
        super();
    }

    public QAFWebElement getTitle() {
        return title;
    }
}
