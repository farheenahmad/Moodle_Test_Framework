package com.netsuite.tlh.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath = "(//tr[@role='radiogroup']//td)[4]")
	private WebElement grade;
	
	@FindBy(css = "button[name='savechanges']")
	private WebElement saveChangesButton;
	
	@FindBy(css = "button[name='saveandshownext']")
	private WebElement saveandShowNextButton;
	
	@FindBy(xpath = "//div[text()='Graded']")
	private WebElement gradedText;
	
	@FindBy(css = "td[class='graded']")
	private WebElement gradedTextEndPage;
	
	@FindBy(css = "select[name='assignmentStatus']")
	private WebElement assignmentStatusDropdown;
	
	@FindBy(css = "a[class='btn btn-primary signoff-button']")
	private WebElement signOffButton;
	
	@FindBy(xpath = "//label[contains(text(),'Grade:')]/ancestor::div[@class='col-md-3']//a//i")
	private WebElement gradeMaximiseButton;

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
		waitForElementToBeClickable(filterButton);
		filterButton.click();
		return this;
	}
	
	public FacilitationManagerDashboardPage refreshPage() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		return this;
	}
	
	public FacilitationManagerDashboardPage openAssigmentsLink() throws Throwable {
		waitForElementToBeVisibile(table);
		waitForElementToBeClickable(table);
	  List <WebElement> elements=BrowserFactory.getDriver().findElements(By.xpath("//td[@class='text-danger bold']/ancestor::tr//td[3]//a"));
	  
	  for(int i=1;i<=elements.size();i++){
		  BrowserFactory.getDriver().navigate().refresh();
		  WebElement element=BrowserFactory.getDriver().findElement(By.xpath("//td[@class='text-danger bold']/ancestor::tr//td[3]//a"));
		  waitForElementToBeClickable(element);
		 // String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		  element.sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
		  gradeAssignment();
	  }   
	   return this;
	}
	
	public FacilitationManagerDashboardPage gradeAssignment() throws Throwable {
		Thread.sleep(2000);
		String currentWindow = BrowserFactory.getDriver().getWindowHandle();
		for(String winHandle : BrowserFactory.getDriver().getWindowHandles()){
			   if (BrowserFactory.getDriver().switchTo().window(winHandle).getTitle().contains("Assignment:")) {
				  clickOneOfTheGrade();
				  clicksaveChangesButton();
				  try{
				  if(gradedText.isDisplayed()==false){
					  clickOneOfTheGrade();
					  clicksaveAndShowNewButton();  
				  }
				  }
				  catch(Exception e){ 
					  waitForElementToBePresent(By.cssSelector("input[value='Ok']"));
					  waitForElementToBeClickable(By.cssSelector("input[value='Ok']"));
					  WebElement ele=BrowserFactory.getDriver().findElement(By.cssSelector("input[value='Ok']"));
		
					  ele.click();
					  clickOneOfTheGrade();
					  clicksaveAndShowNewButton(); 
				  }
				  
				  waitForElementToBeVisibile(gradedText);
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
	
	public FacilitationManagerDashboardPage clickOneOfTheGrade() throws Throwable {
		waitForElementToBeVisibile(gradeMaximiseButton);
		waitForElementToBeClickable(gradeMaximiseButton);
		gradeMaximiseButton.click();
		waitForElementToBePresent(By.cssSelector("tr[role='radiogroup']"));
		List <WebElement> elements=BrowserFactory.getDriver().findElements(By.cssSelector("tr[role='radiogroup']"));
		for(int i=1;i<=elements.size();i++){	
			Thread.sleep(2000);
			waitForElementToBePresent(By.xpath("((//tr[@role='radiogroup'])[" + i + "]//td)[4]"));
			BrowserFactory.getDriver().findElement(By.xpath("((//tr[@role='radiogroup'])[" + i + "]//td)[4]")).click();	
		}	
		return this;
	}
	
	public FacilitationManagerDashboardPage clicksaveChangesButton() throws Throwable {
		
		waitForElementToBeVisibile(saveChangesButton);
		waitForElementToBeClickable(saveChangesButton);
		saveChangesButton.click();
		return this;
	}
	
	public FacilitationManagerDashboardPage clicksaveAndShowNewButton() throws Throwable {
		
		waitForElementToBeVisibile(saveandShowNextButton);
		waitForElementToBeClickable(saveandShowNextButton);
		saveandShowNextButton.click();
		return this;
	}
	
	public FacilitationManagerDashboardPage selectAssignmentStatus(String Status) throws Throwable {
		waitForElementToBeVisibile(assignmentStatusDropdown);
		waitForElementToBeClickable(assignmentStatusDropdown);
		Select sel= new Select(assignmentStatusDropdown);
		sel.selectByVisibleText(Status);
		return this;
	}
	
	public FacilitationManagerDashboardPage checkIfGraded() throws Throwable {
		waitForElementToBeVisibile(gradedTextEndPage);
		waitForElementToBeClickable(gradedTextEndPage);
		
		return this;
	}
	
	public FacilitationManagerDashboardPage clickOnSignOffButton() throws Throwable {
		waitForElementToBeVisibile(signOffButton);
		waitForElementToBeClickable(signOffButton);
		signOffButton.click();
		Thread.sleep(1000);
		Alert alert = BrowserFactory.getDriver().switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		return this;
	}

}
