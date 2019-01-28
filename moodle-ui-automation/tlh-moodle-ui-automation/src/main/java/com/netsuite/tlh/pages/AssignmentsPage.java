package com.netsuite.tlh.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;


public class AssignmentsPage extends MenuBarPage {

	public AssignmentsPage() throws DriverNotInitializedException {
		super();
	}
	
	@FindBy(css = "table[class='generaltable']")
	private WebElement table;
	
	public AssignmentsPage openAssigmentsLink(int n) throws Throwable {
		waitForElementToBeVisibile(table);
	   List<WebElement> elements=BrowserFactory.getDriver().findElements(By.xpath("//table[@class='generaltable']//tbody//tr//td[2]//a"));
	  String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
	  elements.get(n).sendKeys(selectLinkOpeninNewTab);     
	   return this;
	}
	
	
}
