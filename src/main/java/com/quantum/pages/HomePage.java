package com.quantum.pages;

import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.quantum.utils.DeviceUtils;

public class HomePage extends AbstractBasePage {

    public HomePage(){
        super();
        validateHomePage();
    }
    private void validateHomePage(){
        DeviceUtils.waitForPresentTextVisual("Applications", 10);
    }

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub

    }
    

}
