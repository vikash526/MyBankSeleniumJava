package com.mybank.testcase;

import org.testng.annotations.Test;

import org.testng.Assert;
import com.mybank.pageobject.copyEmailPassword;
import com.mybank.pageobject.indexPage;
import com.mybank.pageobject.managerHomePage;
import com.mybank.pageobject.myAccount;

public class TC_MyAccountPage extends BaseClass {
	
	

	@Test(enabled = false)
	public void verifyRegistrationAndLogin() {
		
//		create object for index page class to access method which is in index page(page object)
		indexPage indexPage = new indexPage(driver);
		
		indexPage.clickHereLinkAction();
		logger.info("here link clicked");
		
//		create object for create account page class to access method which is in myAccount page(page object)
		myAccount myAccount = new myAccount(driver);
		myAccount.enterEmailAction("a@a.com");
		logger.info("email entered");
		myAccount.clickSubmitAction();
		logger.info("submitted");
		
//		create object for copyemailpasswod page to access method which is in copyemailpassword page(page object)
		copyEmailPassword copyEmailPassword = new copyEmailPassword(driver);
		String email = copyEmailPassword.savedEmailAction();
		String password = copyEmailPassword.savedPasswordAction();
		
//		back to the login/index page
		driver.get(baseUrl);
		logger.info("back to the login/index page");
		
//		login to the bank page
		indexPage.loginBankPage(email, password);
		logger.info("login success");

		Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank", indexPage.getWelcomeMessage());
		
	}
	
	@Test
	public void verifyRegisteredUser() throws Exception {
		driver.get(baseUrl);
		logger.info("go to the login/index page");
		
//		login to the bank page
		indexPage indexPage = new indexPage(driver);
		indexPage.loginBankPage(user, password);
		logger.info("enter email/password and login");
		
		managerHomePage managerHomePage = new managerHomePage(driver);
		
		if(managerHomePage.getWelcomeMessage().equals("Welcome To Manager's Page of Guru99 Bank")) {
			logger.info("login pass");
			Assert.assertTrue(true);
		}else {
			logger.info("login fail");
			captureScreenShot(driver, "verifyRegisteredUser");
			Assert.assertTrue(false);
		}
		managerHomePage.logOut();
		logger.info("logout success");
	}
}
