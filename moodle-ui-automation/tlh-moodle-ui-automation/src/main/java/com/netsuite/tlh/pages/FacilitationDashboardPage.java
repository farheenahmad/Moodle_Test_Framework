package com.netsuite.tlh.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;

public class FacilitationDashboardPage extends MenuBarPage {

	public FacilitationDashboardPage() throws DriverNotInitializedException {
		super();
	}
	
	@FindBy(id = "filterButton")
	private WebElement filterButton;
	
	@FindBy(name = "studentName")
	private WebElement studentextBox;
	
	@FindBy(name = "courseCode")
	private WebElement courseCodetextBox;
	
	@FindBy(name = "courseName")
	private WebElement courseNametextBox;
	
	@FindBy(name = "assignmentName")
	private WebElement assignmentNametextBox;
	
	@FindBy(id = "resetButton")
	private WebElement resetButton;
	
	@FindBy(css = "select[name='assignmentStatus']")
	private WebElement assignmentStatusDropdown;
	
	@FindBy(css = "table[class='table']")
	private WebElement table;
	
	@FindBy(css = "input[name='expectedCompletionDate']")
	private WebElement expectedCompletionDateInput;
	
	@FindBy(css = "input[name='dateSubmitted']")
	private WebElement dateSubmittedInput;
	
	@FindBy(css = "span[class='flatpickr-day today']")
	private WebElement todaysDate;
	
	@FindBy(css = "span[class='flatpickr-day today selected endRange inRange']")
	private WebElement todaysDate2;
	
	@FindBy(xpath = "(//span[@class='flatpickr-day today'])[3]")
	private WebElement todaysDate3;
	
	
	@FindBy(name = "signOffStatus")
	private WebElement SignOffStatusDropdown;
	
	@FindBy(id = "fecthData")
	private WebElement fetchDataButton;

	
	
	public FacilitationDashboardPage clickOnFetchData() throws Throwable {
		waitForElementToBeVisibile(fetchDataButton);
		waitForElementToBeClickable(fetchDataButton);
		fetchDataButton.click();
		Thread.sleep(2000);
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }};
            
            WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
            wait.until(expectation);
		return this;
	}
		
	public FacilitationDashboardPage clickFilterButton() throws Throwable {
		waitForElementToBeVisibile(filterButton);
		waitForElementToBeClickable(filterButton);
		filterButton.click();
		return this;
	}
	
	public FacilitationDashboardPage enterStudentName(String name) throws Throwable {
		waitForElementToBeVisibile(studentextBox);
		waitForElementToBeClickable(studentextBox);
		studentextBox.clear();
		studentextBox.sendKeys(name);
		return this;
	}
	
	public FacilitationDashboardPage enterCourseCode(String code) throws Throwable {
		waitForElementToBeVisibile(courseCodetextBox);
		waitForElementToBeClickable(courseCodetextBox);
		courseCodetextBox.clear();
		courseCodetextBox.sendKeys(code);
		return this;
	}
	
	public FacilitationDashboardPage enterCourseName(String Name) throws Throwable {
		waitForElementToBeVisibile(courseNametextBox);
		waitForElementToBeClickable(courseNametextBox);
		courseNametextBox.clear();
		courseNametextBox.sendKeys(Name);
		return this;
	}
	
	public FacilitationDashboardPage enterAssignmentName(String AssignmentName) throws Throwable {
		waitForElementToBeVisibile(assignmentNametextBox);
		waitForElementToBeClickable(assignmentNametextBox);
		assignmentNametextBox.clear();
		assignmentNametextBox.sendKeys(AssignmentName);
		return this;
	}
	
	public FacilitationDashboardPage clickResetButton() throws Throwable {
		waitForElementToBeVisibile(resetButton);
		waitForElementToBeClickable(resetButton);
		resetButton.click();
		return this;
	}
	
	public FacilitationDashboardPage selectAssignmentStatus(String Status) throws Throwable {
		waitForElementToBeVisibile(assignmentStatusDropdown);
		waitForElementToBeClickable(assignmentStatusDropdown);
		Select sel= new Select(assignmentStatusDropdown);
		sel.selectByVisibleText(Status);
		return this;
	}
	
	public FacilitationDashboardPage selectSignOffStatus(String Stat) throws Throwable {
		waitForElementToBeVisibile(SignOffStatusDropdown);
		waitForElementToBeClickable(SignOffStatusDropdown);
		Select sel= new Select(SignOffStatusDropdown);
		sel.selectByVisibleText(Stat);
		return this;
	}

	public FacilitationDashboardPage verifyTableIspresent() throws Throwable {
		waitForElementToBeVisibile(table);
		waitForElementToBeClickable(table);
		return this;
	}
	
	public FacilitationDashboardPage selectDateSubmitted() throws Throwable {
		waitForElementToBeVisibile(dateSubmittedInput);
		waitForElementToBeClickable(dateSubmittedInput);
		dateSubmittedInput.click();
		waitForElementToBeVisibile(todaysDate);
		todaysDate.click();
		waitForElementToBeClickable(todaysDate2);
		todaysDate2.click();
		return this;
	}
	
	public FacilitationDashboardPage expectedCompletionDateInput() throws Throwable {
		waitForElementToBeVisibile(expectedCompletionDateInput);
		waitForElementToBeClickable(expectedCompletionDateInput);
		expectedCompletionDateInput.click();
		waitForElementToBeVisibile(todaysDate3);
		todaysDate3.click();
		waitForElementToBeClickable(todaysDate2);
		todaysDate2.click();
		return this;
	}
}
