package com.evs.teasCase;

import org.openqa.selenium.support.PageFactory;

import com.evs.homepage.HomeLandingPage;
import com.evs.login.login_page;
import com.evs.marketingAccounts.AccountDetailsPage;
import com.evs.marketingAccounts.EditAccount;
import com.evs.marketingAccounts.createAccountPage;
import com.evs.marketingAccounts.marketingAccountPage;
import com.evs.vtiger.generic_layer.WebUtil;

public class TestCase {
	
	public void createAccount() {
		WebUtil web=new WebUtil();
		web.generateRepot("accountCreate");
		web.initlog("tc001");
		web.Browerlaunch("chrome");
		web.waitforimplicity(10);
		web.forURLhit("http://localhost:8888//");
		login_page	objOfLoginpage= new login_page();
		
	login_page ObjOflogin=	PageFactory.initElements(web.GetDriver(),login_page.class);
         HomeLandingPage HomeLandingPage =ObjOflogin.valid_login_page(web);
       marketingAccountPage  objOfMarketingAcc= HomeLandingPage.goToMarketingAccount();
		objOfMarketingAcc.clickCreateAccount(web);
		createAccountPage acPage=new createAccountPage();
		acPage.formFill(web);
		acPage.saveAccount(web);
		
		AccountDetailsPage adpObj=new AccountDetailsPage();
		adpObj.verifyAccountInfo("mahi", "09876456789");
		
		web.flushed();
	}
//public void editAccountInfo() {
// WebUtil web=new WebUtil ();
// web.generateRepot("EditAccount");
// web.initlog("tc002");
// web.Browerlaunch("chrome");
// web.waitforimplicity(20);
// web.forURLhit("http://localhost:8888//");
// new login_page(web).valid_login_page();
// new HomeLandingPage(web).goToMarketingAccount();
// new marketingAccountPage().clickEditButton(web);
//EditAccount objOfedit= new EditAccount();
//objOfedit.reEnterDate(web);
//objOfedit.save(web);
//web.flushed();
}

	


