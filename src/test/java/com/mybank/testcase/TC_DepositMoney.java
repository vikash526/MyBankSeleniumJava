package com.mybank.testcase;

import org.testng.annotations.Test;

import com.mybank.pageobject.depositInput;
import com.mybank.pageobject.indexPage;
import com.mybank.pageobject.managerHomePage;

public class TC_DepositMoney extends BaseClass {
	@Test

	public void depositMoney() throws Exception {
		driver.get(baseUrl);
		logger.info("login/index page opened");

//		login to the bank page
		indexPage indexPage = new indexPage(driver);
		indexPage.loginBankPage(user, password);
		logger.info("entered email/password and login");
		
		managerHomePage managerHomePage = new managerHomePage(driver);
		managerHomePage.depositLink();
		
		depositInput depositInput = new depositInput(driver);
		depositInput.accountno("119298");
		depositInput.amount("1300");
		depositInput.desc("holi pay");
		depositInput.accSubmit();
		logger.info("money deposited");
	
//		managerHomePage.logOut();
	}
}