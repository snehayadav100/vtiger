package com.evs.marketingAccounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.generic_layer.WebUtil;

public class EditAccount {
	
	@FindBy(xpath ="//input[@title=\"Save [Alt+S]\"]" )
	 private WebElement savebt;
	
	
  public void save(WebUtil web) {
  // web.searchElement("xpath", "//input[@title=\"Save [Alt+S]\"]");
 web.clickbutton(savebt);  
	  
	  
  }
//  public void reEnterDate(WebUtil web) {
//       WebElement objOfEmail=web.searchElement("xpath", "//input[@id=\"email1\"]");	  
//       web.sendvalue(objOfEmail, "sneha@gmail.com");
//	  
  }

