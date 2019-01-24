package com.netsuite.tlh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;


public class BackUpPage extends BasePage {

	public BackUpPage() throws DriverNotInitializedException {
		super();
	}

	@FindBy(css = "input[id='id_setting_root_users']")
	private WebElement enrolledUserCheckBox;
	
	@FindBy(css = "input[id='id_oneclickbackup']")
	private WebElement jumpToFinalStepButton;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueButton;
	
	
	public BackUpPage removeEnrolledUser() throws Throwable {
		waitForElementToBeClickable(enrolledUserCheckBox);
		waitForElementToBeVisibile(enrolledUserCheckBox);
		enrolledUserCheckBox.click();
		return this;
	}
	
	public BackUpPage clickOnJumpToFinalStep() throws Throwable {
		waitForElementToBeVisibile(jumpToFinalStepButton);
		jumpToFinalStepButton.click();
		return this;
	}
	
	public BackUpPage clickOncontinueButton() throws Throwable {
		waitForElementToBeVisibile(continueButton);
		continueButton.click();
		return this;
	}
	
	
	

}
