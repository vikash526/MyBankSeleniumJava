package com.mybank.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addNewCustomer {
	WebDriver localDriver;

//	constructor
	public addNewCustomer(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
//	identify elements in the add new customer page
	@FindBy(name = "name")
	WebElement name;
	
	@FindBy(xpath = "//input[@value='m']")
	WebElement male;
	@FindBy(xpath = "//input[@value='f']")
	WebElement female;
	@FindBy(id = "dob")
	WebElement dob;
	@FindBy(name = "addr")
	WebElement address;
	
	@FindBy(name = "city")
	WebElement city;
	@FindBy(name = "state")
	WebElement state;
	@FindBy(name = "pinno")
	WebElement pin;
	@FindBy(name = "telephoneno")
	WebElement mobile;
	
	@FindBy(name = "emailid")
	WebElement emailNewCustomer;
	@FindBy(name = "password")
	WebElement passwordNewCustomer;
	
	@FindBy(name = "sub")
	WebElement submitNewCustomer;
	
	@FindBy(xpath = "//table[@border='1']/tbody/tr[1]")
	WebElement messageNewCustomer;
	
//	identify actions on web element in add new customer page
	public void enterNewCustomerDetails(String name, String dob, String address, String city,
			String state, String pin, String mobile, String email, String password) {
		this.name.sendKeys(name);
		this.dob.sendKeys(dob);
		this.address.sendKeys(address);
		this.city.sendKeys(city);
		this.state.sendKeys(state);
		this.pin.sendKeys(pin);
		this.mobile.sendKeys(mobile);
		this.emailNewCustomer.sendKeys(email);
		this.passwordNewCustomer.sendKeys(password);
		submitNewCustomer.click();
	}
	public String addNewCustomerMessage() {
		return messageNewCustomer.getText();
	}
	
}
