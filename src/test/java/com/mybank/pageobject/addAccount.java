package com.mybank.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addAccount {
	WebDriver localDriver;

//	constructor
	public addAccount(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}

//	identify elements in the add new customer page
	@FindBy(name = "cusid")
	WebElement customerIdInput;
	@FindBy(name = "selaccount")
	WebElement selectAccountDropDown;
	@FindBy(name = "inideposit")
	WebElement initialDeposit;
	@FindBy(name = "button2")
	WebElement submitButton;
	@FindBy(name = "reset")
	WebElement resetButton;
	
	@FindBy(xpath = "//table[@border='1']/tbody/tr[1]")
	WebElement accountGenerateMessage;
	
	@FindBy(xpath = "table[@border='1']/tbody/tr[4]/td[2]")
	WebElement accountId;
	@FindBy(xpath = "table[@border='1']/tbody/tr[8]/td[2]")
	WebElement accountType;
	@FindBy(xpath = "table[@border='1']/tbody/tr[9]/td[2]")
	WebElement accountOpeningDate;
	@FindBy(xpath = "table[@border='1']/tbody/tr[10]/td[2]")
	WebElement currentAmount;

//	identify actions on web element in the add new customer page

	public void customerIdInput(String customerId) {
		customerIdInput.sendKeys(customerId);
	}

	public void selectAccountDropDown(String accountType) {
		Select select = new Select(selectAccountDropDown);
		select.selectByValue(accountType);
	}

	public void initialDeposit(String deposit) {
		initialDeposit.sendKeys(deposit);
	}

	public void submitButton() {
		submitButton.click();
	}

	public void resetButton() {
		resetButton.click();
	}
	
	public String accountGenerateMessage() {
		return accountGenerateMessage.getText();
	}
	
	public String accountId() {
		return accountId.getText();
	}
	public String accountType() {
		return accountType.getText();
	}
	public String accountOpeningDate() {
		return accountOpeningDate.getText();
	}
	public String currentAmount() {
		return currentAmount.getText();
	}
}
