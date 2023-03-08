package com.mybank.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mybank.pageobject.addAccount;
import com.mybank.pageobject.indexPage;
import com.mybank.pageobject.managerHomePage;

public class TC_AddBankAccount extends BaseClass {

	@Test
	public void addBankAccount() throws IOException {
//		driver.get(baseUrl);
//		logger.info("login/index page opened");

//		login to the bank page
		indexPage indexPage = new indexPage(driver);
		indexPage.loginBankPage(user, password);
		logger.info("entered email/password and login");

		managerHomePage managerHomePage = new managerHomePage(driver);
		managerHomePage.newAccountLink();

		addAccount addAccount = new addAccount(driver);
		addAccount.customerIdInput("10006");
		addAccount.selectAccountDropDown("Savings");
		addAccount.initialDeposit("10006");
		addAccount.submitButton();

		logger.info("add account details submitted");

		if (addAccount.accountGenerateMessage().equals("Account Generated Successfully!!!")) {
			logger.info("account no generated success");
			Assert.assertTrue(true);
		} else {
			logger.info("account generation failed");
			captureScreenShot(driver, "addBankAccount");
		}
		managerHomePage.logOut();
	}
}