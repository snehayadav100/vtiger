package com.evs.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.marketingAccounts.marketingAccountPage;
import com.evs.vtiger.generic_layer.WebUtil;

public class HomeLandingPage {
	@ FindBy (linkText = "marketing")
	private WebElement marketingLink;
	
	@FindBy (linkText = "accounts")
	private WebElement accountLink;

    private WebUtil WebUtil;
	public HomeLandingPage(WebUtil web) {
	this.WebUtil=web;	
	}

	public marketingAccountPage goToMarketingAccount() {
		
		WebUtil.mouseover(marketingLink, "marketing");
		WebUtil.clickbutton(accountLink);
		
		marketingAccountPage objOfMarketingAcc=new marketingAccountPage();
        return objOfMarketingAcc;
        
	
	}
}
