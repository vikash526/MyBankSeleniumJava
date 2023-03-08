package com.mybank.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class copyEmailPassword {
	WebDriver localDriver;

//	constructor
	public copyEmailPassword(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
		}

//	identify elements in the credential page
	@FindBy(xpath = "//table/tbody/tr[4]/td[2]")
	WebElement copyEmail;

	@FindBy(xpath = "//table/tbody/tr[5]/td[2]")
	WebElement copyPassword;

//	identify actions on those web element in credential page
	public String savedEmailAction() {
		return copyEmail.getText();
	}

	public String savedPasswordAction() {
		return copyPassword.getText();
	}
}
