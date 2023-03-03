package com.evs.marketingAccounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.generic_layer.WebUtil;

public class marketingAccountPage {
	 
	@FindBy(xpath = "//img[@title='Create Account...']" )
	private WebElement createAccount;
	
	@FindBy(xpath = "(//a[text()=\"edit\"])[2]")
	private WebElement edit;
	public void clickCreateAccount(WebUtil web) {
		
		web.clickbutton(createAccount);
	}
    public void clickEditButton(WebUtil web) {
    	web.clickbutton(edit);
    	
    }
}
