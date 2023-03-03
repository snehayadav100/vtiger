package com.evs.marketingAccounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.evs.vtiger.generic_layer.WebUtil;

public class AccountDetailsPage {
//	ExtentTest ext;
	private WebUtil web;
		
	
	@FindBy(xpath = "//span[@id=\"dtlview_Account Name\"]")
	private WebElement accountname;
	
	@FindBy(xpath = "//span[@id=\"dtlview_Phone\"]")
	private WebElement accountphone;
	
//	 public AccountDetailsPage(WebUtil web) {
//	   this.web =web ;
//	 }
	 
	 
	 
	 
public void verifyAccountInfo(String expectedAccoutName, String expectedAccouPhone) {	

	String actualAccountName=web.getAttribute(accountname, "AccountName");
	String actualAccountPhone=web.getAttribute(accountphone, "AccountPhone");

	
//	if(actualAccountName.equals(expectedAccoutName) && actualAccountPhone.equals(expectedAccouPhone)){
//		ext.log(Status.PASS, "Account Information is correct");
//	}else {
//		ext.log(Status.FAIL, "Account Information is incorrect");
//
	}
	
	public void verifyAccountName(String expectedAccoutName) {	

	//	String actualAccountName=web.getAttribute("//span[@id=\"dtlview_Account Name\"]","xpath", "AccountName");

		
//		if(actualAccountName.equals(expectedAccoutName) ){
//			ext.log(Status.PASS, "Account Name is correct");
//		}else {
//			ext.log(Status.FAIL, "Account Name is incorrect");

		}
	
	
	 }
 

