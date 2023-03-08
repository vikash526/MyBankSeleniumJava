package com.mybank.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class depositInput {
	WebDriver localDriver;

//	constructor
	public depositInput(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
		}

//	identify elements in the deposit form page
	@FindBy(name = "accountno")
	WebElement accountno;
	
	@FindBy(name = "balance")
	WebElement amount;
	
	@FindBy(name = "desc")
	WebElement desc;
	@FindBy(name = "AccSubmit")
	WebElement accSubmit;
	@FindBy(name = "res")
	WebElement resetButton;
	
//	identify actions on web elements in the deposit form page
	
	public void accountno(String accountNo) {
		accountno.sendKeys(accountNo);
	}
	public void amount(String amountVal) {
		amount.sendKeys(amountVal);
	}
	
	public void desc(String descVal) {
		desc.sendKeys(descVal);
	}
	public void accSubmit() {
		accSubmit.click();
	}
	public void resetButton() {
		resetButton.click();
	}
}
