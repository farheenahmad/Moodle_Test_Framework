package com.netsuite.tlh.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.framework.exceptions.DriverNotInitializedException;


public class MenuBarPage extends BasePage {

	public MenuBarPage() throws DriverNotInitializedException {
		super();
	}
	
	@FindBy(css = "a[id='dropdown-1']")
	private WebElement menuBarDropdown;
	
	@FindBy(css = "i[title='Log out']")
	private WebElement logOut;
	
	
	public MenuBarPage clickmenuBarDropDown() throws Throwable {
		waitForElementToBeVisibile(menuBarDropdown);
		menuBarDropdown.click();
		return this;
	}
	
	public MenuBarPage clicklogOut() throws Throwable {
		waitForElementToBeVisibile(logOut);
		waitForElementToBeClickable(logOut);
		logOut.click();
		return this;
	}
	
	
}
