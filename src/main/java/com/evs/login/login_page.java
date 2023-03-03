package com.evs.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.homepage.HomeLandingPage;
import com.evs.vtiger.generic_layer.WebUtil;

public class login_page {
	
@FindBy(name="user_name")	
 private WebElement userNameboxEd;

@FindBy(xpath="//input[@name=user_password']")
 private WebElement userpassboxEd;

@FindBy(xpath="//input[@name='Login']")
 private WebElement userloginBt;

// private WebUtil WebUtil;
 
// public login_page(WebUtil web) {
//  this.WebUtil = web;	 
// }
	
     public HomeLandingPage valid_login_page(WebUtil WebUtil) {
	WebUtil.forURLhit("http://localhost:8888//");
	 WebUtil.sendvalue(userNameboxEd, "admin");
	 WebUtil.sendvalue(userpassboxEd, "admin");
	WebUtil.sendvalue(userloginBt, "Login");	
	HomeLandingPage	objOfHomePage=new HomeLandingPage(WebUtil);
   return objOfHomePage;

	
	}
	}	