package com.quantum.pages;

import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.quantum.utils.DeviceUtils;

public class RealEstateHomePage extends AbstractBasePage {

    public RealEstateHomePage(){
        super();
        validateRealEstateHomePage();
    }
    private void validateRealEstateHomePage(){
        DeviceUtils.waitForPresentTextVisual("Applications", 10);
    }

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub

    }
    

}
