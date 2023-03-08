package com.mybank.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mybank.pageobject.addNewCustomer;
import com.mybank.pageobject.indexPage;
import com.mybank.pageobject.managerHomePage;

public class TC_AddNewCustomer extends BaseClass {
	
	@Test
	public void addNewCustomerBankAccount() throws Exception {
//		driver.get(baseUrl);
//		logger.info("login/index page opened");
		
//		login to the bank page
		indexPage indexPage = new indexPage(driver);
		indexPage.loginBankPage(user, password);
		logger.info("entered email/password and login");
		
		managerHomePage managerHomePage = new managerHomePage(driver);
		managerHomePage.newCustomerLink();
		
		addNewCustomer addNewCustomer = new addNewCustomer(driver);
		addNewCustomer.enterNewCustomerDetails("kumar", "6/6/1999", "manpur", "gaya", "bihar", "823003", "1234567890", "vik123@yah.com", "m123");
		logger.info("new customer details entered and submitted");
		
		if(addNewCustomer.addNewCustomerMessage().equals("Customer Registered Successfully!!!")) {
			logger.info("registeration passed");
			Assert.assertTrue(true);
		}else {
			logger.info("registration failed");
			captureScreenShot(driver, "addNewCustomerBankAccount");
			Assert.assertTrue(false);
		}
		
	}
}
