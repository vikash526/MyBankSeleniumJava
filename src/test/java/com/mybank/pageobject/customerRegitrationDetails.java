package com.mybank.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class customerRegitrationDetails {
	WebDriver localDriver;

//	constructor
	public customerRegitrationDetails(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
//	identify elements in the customer registration page
	@FindBy(xpath = "//table[@border=\\\"1\\\"]/tbody/tr[4]/td[2]")
	WebElement customerId;
	@FindBy(xpath = "//table[@border=\\\"1\\\"]/tbody/tr[5]/td[2]")
	WebElement customerName;
	@FindBy(xpath = "//table[@border=\\\"1\\\"]/tbody/tr[6]/td[2]")
	WebElement customerGender;
	@FindBy(xpath = "//table[@border=\\\"1\\\"]/tbody/tr[7]/td[2]")
	WebElement customerBirthdate;
	@FindBy(xpath = "//table[@border=\\\"1\\\"]/tbody/tr[8]/td[2]")
	WebElement customerAddress;
	@FindBy(xpath = "//table[@border=\\\"1\\\"]/tbody/tr[9]/td[2]")
	WebElement customerCity;
	@FindBy(xpath = "//table[@border=\\\"1\\\"]/tbody/tr[10]/td[2]")
	WebElement customerState;
	@FindBy(xpath = "//table[@border=\\\"1\\\"]/tbody/tr[11]/td[2]")
	WebElement customerPin;
	@FindBy(xpath = "//table[@border=\\\"1\\\"]/tbody/tr[12]/td[2]")
	WebElement customerMobile;
	@FindBy(xpath = "//table[@border=\\\"1\\\"]/tbody/tr[13]/td[2]")
	WebElement customerEmail;
	@FindBy(linkText = "Continue")
	WebElement continueButton;
	
//	identify actions on web element in customer registration page
	public String customerId() {
		return customerId.getText();
	}
	public String customerName() {
		return customerName.getText();
	}
	public String customerGender() {
		return customerGender.getText();
	}
	public String customerBirthdate() {
		return customerBirthdate.getText();
	}
	public String customerAddress() {
		return customerAddress.getText();
	}
	public String customerCity() {
		return customerCity.getText();
	}
	public String customerState() {
		return customerState.getText();
	}
	public String customerPin() {
		return customerPin.getText();
	}
	public String customerMobile() {
		return customerMobile.getText();
	}
	public String customerEmail() {
		return customerEmail.getText();
	}
	public void continueButton() {
		continueButton.click();
	}
}
