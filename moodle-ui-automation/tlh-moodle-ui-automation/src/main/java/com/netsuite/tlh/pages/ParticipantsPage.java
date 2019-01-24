package com.netsuite.tlh.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;


public class ParticipantsPage extends BasePage {

	public ParticipantsPage() throws DriverNotInitializedException {
		super();
	}

	@FindBy(css = "input[value='Enrol users']")
	private WebElement enrollUsersButton;
	
	@FindBy(css = "input[placeholder='Search']")
	private WebElement usersInputBox;
	
	@FindBy(css = "select[id='id_roletoassign']")
	private WebElement roleBox;
	
	@FindBy(xpath = "//button[text()='Enrol users']")
	private WebElement enrollUsersSaveButton;
	
	@FindBy(css = "div[data-region='header']")
	private WebElement header;
	
	

	public ParticipantsPage clickOnEnrolUsers() throws Throwable {
		waitForElementToBeClickable(enrollUsersButton);
		waitForElementToBeVisibile(enrollUsersButton);
		enrollUsersButton.click();
		return this;
	}
	
	public ParticipantsPage selectUsers(String UserName) throws Throwable {
		waitForElementToBeVisibile(usersInputBox);
		waitForElementToBeClickable(usersInputBox);
		usersInputBox.sendKeys(UserName);
		waitForElementToBeVisibile(header);
		header.click();
		
		/*Eric Rodrigo
		Salvatore Ajami
		Admin User
		anne babcock*/
		//usersInputBox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public ParticipantsPage selectRoles(String Role) throws Throwable {
		waitForElementToBeVisibile(roleBox);
		waitForElementToBeClickable(roleBox);
		Select sel= new Select(roleBox);
		sel.selectByVisibleText(Role);
		/*Student
		Facilitator
		Facilitation Manager*/
		usersInputBox.sendKeys(Keys.ENTER);
		
		
		return this;
	}
	
	public ParticipantsPage clickOnEnrolUsersSaveButton() throws Throwable {
		waitForElementToBeVisibile(enrollUsersSaveButton);
		waitForElementToBeClickable(enrollUsersSaveButton);
		enrollUsersSaveButton.click();
		Thread.sleep(2000);
		return this;
	}
	
}