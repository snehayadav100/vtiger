package com.evs.runner;

import com.evs.login.login_page;
import com.evs.marketingAccounts.createAccountPage;
import com.evs.teasCase.TestCase;
import com.evs.vtiger.generic_layer.WebUtil;

public class runner {

	public static void main(String[]args) {
		TestCase objOfCAccount=new TestCase();
		
		
		objOfCAccount.createAccount();
//		objOfCAccount.editAccountInfo();	
		
		
	
	}
}
