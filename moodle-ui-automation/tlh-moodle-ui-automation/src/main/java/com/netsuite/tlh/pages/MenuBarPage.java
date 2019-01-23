package com.netsuite.tlh.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.framework.exceptions.DriverNotInitializedException;


public class MenuBarPage extends BasePage {

	public MenuBarPage() throws DriverNotInitializedException {
		super();
	}

	@FindBy(css = "span[class='userbutton']")
	private WebElement userNav;
	
	@FindBy(css = "i[title='Log out']")
	private WebElement logout;
	
	

	public MenuBarPage clickOnUserNav() throws Throwable {
		waitForElementToBeVisibile(userNav);
		userNav.click();
		return this;
	}
	
	public MenuBarPage clickLogOut() throws Throwable {
		waitForElementToBeVisibile(logout);
		logout.click();
		return this;
	}
	
	
}
