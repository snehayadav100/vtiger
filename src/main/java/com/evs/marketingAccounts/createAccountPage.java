package com.evs.marketingAccounts;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.generic_layer.WebUtil;

public class createAccountPage {
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBt;
	
	@FindBy(xpath = "//input[@name='accountname']\"")
	private WebElement canclebt;
	
	@FindBy(xpath =  "//input[@name=\"website\"]" )
	private WebElement  mahi;
	
	@FindBy(xpath ="//input[@name=\"tickersymbol\"]")
	private WebElement plush;
	
	@FindBy(xpath =  "//input[@id=\"phone\"]")
	private WebElement 5676777732;
	
	@FindBy(xpath = "//input[@id=\"email1\"]")
	private WebElement snehayadav@gmail.com;
	public void saveAccount(WebUtil web) {
	
    web.clickbutton(saveBt);
		
	}

	public void cancelAccount() {
		
	}
	public void formFill(WebUtil web) {
		
	web.clickbutton(canclebt);
	
		web.sendvalue(canclebt, "mahi");
     //   web.searchElement(mahi);
        web.sendvalue(canclebt, "localhost");
     //   WebElement ticketSymbolName=web.searchElement();
        web.sendvalue(canclebt, "plush");
      //  WebElement phoneNo=web.searchElement("xpath", "//input[@id=\"phone\"]");
        web.sendvalue(canclebt, "475977898");
       // WebElement faxNo=web.searchElement("xpath", "//input[@id=\"fax\"]");
        web.sendvalue(canclebt, "670989890");
     //   WebElement email=web.searchElement("xpath", "//input[@id=\"email1\"]");
        web.sendvalue(canclebt, "e4ryye4u@gmail.com")	;	
        
        
       web.clickbutton("xpath", "//img[@title=\"Select\"]");
       web.ForWindowHandleByURL("http://localhost:8888//index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
       web.clickbutton("xpath", "//a[text()=\"gooduivtiger\"]");
      
       
       web.ForAlertAccept("popup");
       web.ForWindowHandlebyTitle("admin - Marketing - Accounts - vtiger CRM 5 - Commercial Open Source CRM");
       
       
////       web.ForWindowHandle("");  
       web.clickbutton("xpath", "//input[@title=\"Save [Alt+S]\"]");
        
    
        
		
	

