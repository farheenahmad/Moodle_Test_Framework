package com.netsuite.tlh.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;

public class FacilitationManagerDashboardPage extends MenuBarPage {

	public FacilitationManagerDashboardPage() throws DriverNotInitializedException {
		super();
	}

	@FindBy(css = "input[name='dateSubmitted']")
	private WebElement dateSubmittedInput;
	
	@FindBy(css = "span[class='flatpickr-day today']")
	private WebElement todaysDate;
	
	@FindBy(css = "span[class='flatpickr-day today selected endRange inRange']")
	private WebElement todaysDate2;
	
	@FindBy(id = "filterButton")
	private WebElement filterButton;
	
	@FindBy(css = "table[class='table']")
	private WebElement table;

	public FacilitationManagerDashboardPage selectDateSubmitted() throws Throwable {
		waitForElementToBeVisibile(dateSubmittedInput);
		dateSubmittedInput.click();
		waitForElementToBeVisibile(todaysDate);
		todaysDate.click();
		waitForElementToBeClickable(todaysDate2);
		todaysDate2.click();
		return this;
	}
	
	public FacilitationManagerDashboardPage clickFilterButton() throws Throwable {
		waitForElementToBeVisibile(filterButton);
		filterButton.click();
		return this;
	}
	
	public FacilitationManagerDashboardPage openAssigmentsLink() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		waitForElementToBeVisibile(table);
	  WebElement elements=BrowserFactory.getDriver().findElement(By.xpath("//td[@class='text-danger bold']/ancestor::tr//td[3]//a"));
	  waitForElementToBeClickable(elements);
	  String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
	  elements.sendKeys(selectLinkOpeninNewTab);     
	   return this;
	}
	
	public FacilitationManagerDashboardPage gradeAssignment() throws Throwable {
		Thread.sleep(2000);
		String currentWindow = BrowserFactory.getDriver().getWindowHandle();
		for(String winHandle : BrowserFactory.getDriver().getWindowHandles()){
			   if (BrowserFactory.getDriver().switchTo().window(winHandle).getTitle().contains("Assignment:")) {
			    System.out.println("In tab");
			     BrowserFactory.getDriver().close();
			     break;
			   } 
			   else {
				   BrowserFactory.getDriver().switchTo().window(currentWindow);
			   } 
	        
			   BrowserFactory.getDriver().switchTo().window(currentWindow);
	}
		BrowserFactory.getDriver().switchTo().window(currentWindow);
		return this;
	}

}
