package com.netsuite.tlh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;


public class LoginPage extends BasePage {

	public LoginPage() throws DriverNotInitializedException {
		super();
	}

	@FindBy(id = "login_username")
	private WebElement userName;

	@FindBy(id = "login_password")
	private WebElement password;

	@FindBy(css = "input[value='Log in']")
	private WebElement loginBtn;
	
	@FindBy(id = "username")
	private WebElement secondUserName;

	@FindBy(id = "password")
	private WebElement secondPassword;

	@FindBy(id = "loginbtn")
	private WebElement secondLoginBtn;



	public LoginPage enterUserName(String emailId) throws Throwable {
		waitForElementToBeVisibile(userName);
		userName.clear();
		userName.sendKeys(emailId);
		return this;
	}

	public LoginPage enterPassword(String passWord) throws Throwable {
		waitForElementToBeVisibile(password);
		password.clear();
		password.sendKeys(passWord);
		return this;
	}
	public LoginPage clickLoginButton() throws Throwable {
		waitForElementToBeVisibile(loginBtn);
		loginBtn.click();
		return this;
	}

	public LoginPage doLogIn(String userName, String passWord) throws Throwable {
		enterUserName(userName);
		enterPassword(passWord);
		clickLoginButton();
			
		return this;
			
	}

	public LoginPage enterSecondUserName(String emailId) throws Throwable {
		waitForElementToBeVisibile(secondUserName);
		secondUserName.clear();
		secondUserName.sendKeys(emailId);
		return this;
	}

	public LoginPage enterSecondPassword(String passWord) throws Throwable {
		waitForElementToBeVisibile(secondPassword);
		secondPassword.clear();
		secondPassword.sendKeys(passWord);
		return this;
	}
	public LoginPage clickSecondLoginButton() throws Throwable {
		waitForElementToBeVisibile(secondLoginBtn);
		secondLoginBtn.click();
		return this;
	}

	public LoginPage doSecondLogIn(String userName, String passWord) throws Throwable {
		enterSecondUserName(userName);
		enterSecondPassword(passWord);
		clickSecondLoginButton();
			
		return this;
			
	}
	

}
