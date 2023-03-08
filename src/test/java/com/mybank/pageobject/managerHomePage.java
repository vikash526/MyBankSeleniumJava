package com.mybank.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class managerHomePage {
	WebDriver localDriver;

//	constructor
	public managerHomePage(WebDriver remoteDriver) {
		// TODO Auto-generated constructor stub
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);

	}

//	identify elements in manager home page
	@FindBy(css = "marquee.heading3")
	WebElement headingText;

	@FindBy(linkText = "Log out")
	WebElement logOut;

	@FindBy(linkText = "New Customer")
	WebElement newCustomerLink;
	
	@FindBy(linkText = "New Account")
	WebElement newAccountLink;
	
	@FindBy(linkText = "Deposit")
	WebElement depositLink;

//	identify actions on those web element in manager home page
	public String getWelcomeMessage() {
		// TODO Auto-generated method stub
		return headingText.getText();
	}

	public void logOut() {
		logOut.click();
		localDriver.switchTo().alert().accept();
	}

	public void newCustomerLink() {
		newCustomerLink.click();
	}
	public void newAccountLink() {
		newAccountLink.click();
	}
	public void depositLink() {
		depositLink.click();
	}
}
