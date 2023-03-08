package com.mybank.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

	WebDriver localDriver;
	
//	constructor
	public indexPage(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
		
	}
//	identify elements in the index page
	@FindBy(linkText = "here")
	WebElement here;
	
	@FindBy(name = "uid")
	WebElement uid;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "btnLogin")
	WebElement btnLogin;
	
	@FindBy(css = "marquee.heading3")
	WebElement headingText;
	
	
//	identify actions on those web element in index page
	public void clickHereLinkAction() {
		here.click();
	}
//	login to the bank page
	
	public void loginBankPage(String user, String password2) {
		// TODO Auto-generated method stub
		uid.sendKeys(user);
		password.sendKeys(password2);
		btnLogin.click();
	}
	
	public String getWelcomeMessage() {
		// TODO Auto-generated method stub
		return headingText.getText();
	}
	
}
