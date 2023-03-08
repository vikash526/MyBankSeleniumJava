package com.mybank.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
	WebDriver localDriver;

//	constructor
	public myAccount(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);

	}

//	identify elements in the create account page
	@FindBy(name = "emailid")
	WebElement emailid;
 
	@FindBy(css = "input[value='Submit']")
	WebElement submitCreate;

//	identify actions on those web element in create account page
	public void enterEmailAction(String email) {
		emailid.sendKeys(email);
	}

	public void clickSubmitAction() {
		submitCreate.click();
	}

}
