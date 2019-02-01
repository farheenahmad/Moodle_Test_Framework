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
	
	@FindBy(xpath = "//h1[contains(text(),'AutomationMoodleCourse')]")
	private WebElement automationMoodleCourseHeading;
	
	@FindBy(css = "button[type='submit']")
	private WebElement addSubmissionButton;
	
	@FindBy(css = "div[class='dndupload-message']>div[class='dndupload-arrow']")
	private WebElement dragAndDropButton;
	
	@FindBy(css = "input[name='repo_upload_file']")
	private WebElement fileUploadInput;
	
	@FindBy(css = "button[class='fp-upload-btn btn-primary btn']")
	private WebElement uploadThisFileButton;
	
	@FindBy(css = "input[id='id_submitbutton']")
	private WebElement saveChangesButton;
	
	@FindBy(xpath = "//td[text()='Submitted for grading']")
	private WebElement submittedForGradingText;
	
	public AssignmentsPage openAssigmentsLink() throws Throwable {
		waitForElementToBeVisibile(table);
	   List<WebElement> elements=BrowserFactory.getDriver().findElements(By.xpath("//table[@class='generaltable']//tbody//tr//td[2]//a"));
	 for(int i=0;i<elements.size();i++){
		 String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		  elements.get(i).sendKeys(selectLinkOpeninNewTab); 
		  completeAssignment();
		 
	 }       
	   return this;
	}
	
	public AssignmentsPage completeAssignment() throws Throwable {
		Thread.sleep(2000);
		String currentWindow = BrowserFactory.getDriver().getWindowHandle();
		for(String winHandle : BrowserFactory.getDriver().getWindowHandles()){
			   if (BrowserFactory.getDriver().switchTo().window(winHandle).getTitle().equalsIgnoreCase("Assignment")) {
			     waitForElementToBeVisibile(automationMoodleCourseHeading);
			     clickAddSubmissionButton();
			     clickDragAndDropButton();
			     uploadFile();
			     clickuploadThisFileButton();
			     clicksaveChangesButton();
			     verifySubmission();
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
	
	public AssignmentsPage clickAddSubmissionButton() throws Throwable {
		waitForElementToBeVisibile(addSubmissionButton);
		addSubmissionButton.click();
	   return this;
	}
	
	public AssignmentsPage clickDragAndDropButton() throws Throwable {
		waitForElementToBeVisibile(dragAndDropButton);
		dragAndDropButton.click();
	   return this;
	}
	
	public AssignmentsPage uploadFile() throws Throwable {
		waitForElementToBeVisibile(fileUploadInput);
		fileUploadInput.sendKeys(System.getProperty("user.dir")+"/src/test/resources/testdata/TLH.txt");
	   return this;
	}
	
	public AssignmentsPage clickuploadThisFileButton() throws Throwable {
		waitForElementToBeVisibile(uploadThisFileButton);
		uploadThisFileButton.click();
	   return this;
	}
	
	public AssignmentsPage clicksaveChangesButton() throws Throwable {
		waitForElementToBeVisibile(saveChangesButton);
		saveChangesButton.click();
	   return this;
	}
	
	public AssignmentsPage verifySubmission() throws Throwable {
		waitForElementToBeVisibile(submittedForGradingText);
		
	   return this;
	}
	
	public AssignmentsPage refreshPage() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		
	   return this;
	}
	
	
}
