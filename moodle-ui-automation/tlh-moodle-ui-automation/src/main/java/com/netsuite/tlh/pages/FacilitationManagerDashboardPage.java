package com.netsuite.tlh.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	@FindBy(id = "filterButton")
	private WebElement filterButton;
	
	@FindBy(css = "table[class='table']")
	private WebElement table;
	
	@FindBy(css = "table[class='table']>tbody>tr")
	private WebElement tableData;
	
	@FindBy(xpath = "(//tr[@role='radiogroup']//td)[4]")
	private WebElement grade;
	
	@FindBy(css = "button[name='savechanges']")
	private WebElement saveChangesButton;
	
	@FindBy(css = "button[name='saveandshownext']")
	private WebElement saveandShowNextButton;
	
	@FindBy(xpath = "//div[text()='Graded']")
	private WebElement gradedText;
	
	@FindBy(xpath = "//td[contains(text(),'Graded')]")
	private WebElement gradedTextEndPage;
	
	@FindBy(css = "select[name='assignmentStatus']")
	private WebElement assignmentStatusDropdown;
	
	@FindBy(css = "a[class='btn btn-primary signoff-button']")
	private WebElement signOffButton;
	
	@FindBy(xpath = "//label[contains(text(),'Grade:')]/ancestor::div[@class='col-md-3']//a//i")
	private WebElement gradeMaximiseButton;
	
	@FindBy(css = "input[name='dateGraded']")
	private WebElement dateGradedInput;
	
	@FindBy(xpath = "(//span[@class='flatpickr-day today'])[2]")
	private WebElement todaysGradedDate;
	
	@FindBy(xpath = "//h3[contains(text(),'Previous Grades')]")
	private WebElement previoudGrades;
	
	@FindBy(css = "table[class='criteria']>tbody>tr")
	private WebElement previoudGradesTable;
	
	@FindBy(xpath = "//table[@class='table']//tbody//tr//td[contains(text(),'Signed-off')]")
	private WebElement signedOffText;
	
	@FindBy(name = "facilitatorName")
	private WebElement facilitatortextBox;
	
	@FindBy(id = "resetButton")
	private WebElement resetButton;
	
	@FindBy(name = "studentName")
	private WebElement studentextBox;
	
	@FindBy(name = "assignmentName")
	private WebElement assignmentNametextBox;
	
	@FindBy(name = "courseCode")
	private WebElement courseCodetextBox;
	
	@FindBy(name = "courseName")
	private WebElement courseNametextBox;
	
	@FindBy(name = "signOffStatus")
	private WebElement SignOffStatusDropdown;
	
	@FindBy(css = "input[name='expectedCompletionDate']")
	private WebElement expectedCompletionDateInput;
	
	@FindBy(xpath = "(//span[@class='flatpickr-day today'])[3]")
	private WebElement todaysDate3;
	
	@FindBy(xpath = "(//span[@class='flatpickr-day today'])[4]")
	private WebElement todaysDate4;
	
	@FindBy(name = "originalGrader")
	private WebElement originalGraderTextBox;
	
	@FindBy(name = "courseStartDate")
	private WebElement courseStartDateDropDown;

	@FindBy(xpath = "//span[@class='flatpickr-day today selected endRange inRange']")
	private WebElement todaysDate2;
	
	@FindBy(css = "span[class='flatpickr-day today selected endRange inRange']")
	private WebElement todaysGradedDate2;
	
	@FindBy(xpath = "//*[text()='Facilitation Manager Dashboard']")
	private WebElement facilitationManagerDashboardLink;
	
	@FindBy(css = "td[class='resubmitted']")
	private WebElement resubmitedAssignment;
	
	public FacilitationManagerDashboardPage verifyResubmitedAssignment() throws Throwable {
		waitForElementToBeVisibile(resubmitedAssignment);
		waitForElementToBeClickable(resubmitedAssignment);
		return this;
	}
	
	public FacilitationManagerDashboardPage selectCourseStartDate() throws Throwable {
		waitForElementToBeVisibile(courseStartDateDropDown);
		courseStartDateDropDown.click();
		waitForElementToBeClickable(todaysDate3);
		waitForElementToBeVisibile(todaysDate3);
		todaysDate3.click();
		waitForElementToBeClickable(todaysDate2);
		todaysDate2.click();
		return this;
	}
	
	public FacilitationManagerDashboardPage enterOriginalGraderName(String GraderName) throws Throwable {
		waitForElementToBeVisibile(originalGraderTextBox);
		waitForElementToBeClickable(originalGraderTextBox);
		originalGraderTextBox.clear();
		originalGraderTextBox.sendKeys(GraderName);
		return this;
	}
	
	
	public FacilitationManagerDashboardPage expectedCompletionDateInput() throws Throwable {
		waitForElementToBeVisibile(expectedCompletionDateInput);
		expectedCompletionDateInput.click();
		waitForElementToBeVisibile(todaysDate4);
		waitForElementToBeClickable(todaysDate4);
		todaysDate4.click();
		waitForElementToBeClickable(todaysDate2);
		todaysDate2.click();
		return this;
	}
	
	public FacilitationManagerDashboardPage selectSignOffStatus(String Stat) throws Throwable {
		waitForElementToBeVisibile(SignOffStatusDropdown);
		waitForElementToBeClickable(SignOffStatusDropdown);
		Select sel= new Select(SignOffStatusDropdown);
		sel.selectByVisibleText(Stat);
		return this;
	}
	
	public FacilitationManagerDashboardPage enterCourseName(String Name) throws Throwable {
		waitForElementToBeVisibile(courseNametextBox);
		waitForElementToBeClickable(courseNametextBox);
		courseNametextBox.clear();
		courseNametextBox.sendKeys(Name);
		return this;
	}
	
	public FacilitationManagerDashboardPage enterCourseCode(String code) throws Throwable {
		waitForElementToBeVisibile(courseCodetextBox);
		waitForElementToBeClickable(courseCodetextBox);
		courseCodetextBox.clear();
		courseCodetextBox.sendKeys(code);
		return this;
	}
	
	public FacilitationManagerDashboardPage enterAssignmentName(String AssignmentName) throws Throwable {
		waitForElementToBeVisibile(assignmentNametextBox);
		waitForElementToBeClickable(assignmentNametextBox);
		assignmentNametextBox.clear();
		assignmentNametextBox.sendKeys(AssignmentName);
		return this;
	}
	
	public FacilitationManagerDashboardPage enterStudentName(String name) throws Throwable {
		waitForElementToBeVisibile(studentextBox);
		waitForElementToBeClickable(studentextBox);
		studentextBox.clear();
		studentextBox.sendKeys(name);
		return this;
	}
		
	public FacilitationManagerDashboardPage clickResetButton() throws Throwable {
		waitForElementToBeVisibile(resetButton);
		waitForElementToBeClickable(resetButton);
		resetButton.click();
		return this;
	}
	
	public FacilitationManagerDashboardPage enterFacilitatorName(String facilitatorname) throws Throwable {
		waitForElementToBeVisibile(facilitatortextBox);
		waitForElementToBeClickable(facilitatortextBox);
		facilitatortextBox.clear();
		facilitatortextBox.sendKeys(facilitatorname);
		return this;
	}

	public FacilitationManagerDashboardPage verifyRubricView() throws Throwable {
		waitForElementToBeVisibile(previoudGrades);
		waitForElementToBeVisibile(previoudGradesTable);
		
		return this;
	}
	
	public FacilitationManagerDashboardPage selectDateSubmitted() throws Throwable {
		clickResetButton();
		BrowserFactory.getDriver().navigate().refresh();
		waitForElementToBeVisibile(dateSubmittedInput);
		dateSubmittedInput.click();
		waitForElementToBeVisibile(todaysDate);
		todaysDate.click();
		waitForElementToBeClickable(todaysDate2);
		todaysDate2.click();
		return this;
	}
	
	public FacilitationManagerDashboardPage selectDateGraded() throws Throwable {
		waitForElementToBeVisibile(dateGradedInput);
		dateGradedInput.click();
		waitForElementToBeVisibile(todaysGradedDate);
		todaysGradedDate.click();
		waitForElementToBeClickable(todaysGradedDate2);
		todaysGradedDate2.click();
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
	
	public FacilitationManagerDashboardPage getDashboardRefreshTimeStamp() throws Throwable {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }};
		waitForElementToBeVisibile(tableData);
		long start=System.currentTimeMillis();
		BrowserFactory.getDriver().navigate().refresh();
		WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
		wait.until(expectation);
		long finish=System.currentTimeMillis();
		long totalTime=finish- start;
		System.out.println("TotalTime taken for Dashboard to refresh = "+ totalTime +" milli Second");
		return this;
	}
	
	public FacilitationManagerDashboardPage getGradedFilterTimeStamp() throws Throwable {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }};
        waitForElementToBeVisibile(filterButton);
        waitForElementToBeClickable(filterButton);
		long start=System.currentTimeMillis();
		filterButton.click();
		WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
		wait.until(expectation);
		long finish=System.currentTimeMillis();
		long totalTime=finish- start;
		System.out.println("TotalTime taken for Graded Filter Dashboard = "+ totalTime +" milli Second");
		return this;
	}
	
	public FacilitationManagerDashboardPage waitforPageLoad() throws Throwable {
		
		
		return this;
	}
	
	public FacilitationManagerDashboardPage getDashboardLoadingTimeStamp() throws Throwable {
		
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
          }};
		waitForElementToBeVisibile(facilitationManagerDashboardLink);
		waitForElementToBeClickable(facilitationManagerDashboardLink);
		long start=System.currentTimeMillis();
		facilitationManagerDashboardLink.click();
		WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
        wait.until(expectation);
		long finish=System.currentTimeMillis();
		long totalTime=finish- start;
		System.out.println("TotalTime taken for dashboard to load = "+ totalTime +" milli Second");
		return this;
	}
	
	public FacilitationManagerDashboardPage openAssigmentsLink() throws Throwable {
		waitForElementToBeVisibile(table);
		waitForElementToBeClickable(table);
	  List <WebElement> elements=BrowserFactory.getDriver().findElements(By.xpath("//td[@class='text-danger bold']/ancestor::tr//td[3]//a"));
	  Thread.sleep(1000);
	  for(int i=1;i<=elements.size();i++){
		  BrowserFactory.getDriver().navigate().refresh();
		  WebElement element=BrowserFactory.getDriver().findElement(By.xpath("//td[@class='text-danger bold']/ancestor::tr//td[3]//a"));
		  waitForElementToBeClickable(element);
		  element.sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
		  if(i==2){
			  Thread.sleep(2000);
				String currentWindow = BrowserFactory.getDriver().getWindowHandle();
				for(String winHandle : BrowserFactory.getDriver().getWindowHandles()){
					   if (BrowserFactory.getDriver().switchTo().window(winHandle).getTitle().contains("Assignment:")) {
						   verifyRubricView();   	   
					   }}  
				BrowserFactory.getDriver().switchTo().window(currentWindow);
		  }
		  gradeAssignment();
		  verifyTableIspresent();
	  }   
	   return this;
	}
	
	public FacilitationManagerDashboardPage openAssigmentsLink2() throws Throwable {
		waitForElementToBeVisibile(table);
		waitForElementToBeClickable(table);
	  BrowserFactory.getDriver().findElement(By.xpath("//a[text()='Module 2 Project Checkpoint']")).click();
	  Thread.sleep(2000);
	  String currentWindow = BrowserFactory.getDriver().getWindowHandle();
		for(String winHandle : BrowserFactory.getDriver().getWindowHandles()){
			   if (BrowserFactory.getDriver().switchTo().window(winHandle).getTitle().contains("Assignment:")) {
				   gradeAssignment2(); 	   
			   }}  
		BrowserFactory.getDriver().switchTo().window(currentWindow);
	    
	   return this;
	}
	
	public FacilitationManagerDashboardPage verifyGradedUngradedFilters() throws Throwable {
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String dt= dateFormat.format(date);
		waitForElementToBePresent(By.xpath("//td[contains(text(),'Graded')]/preceding-sibling::td[contains(text(),'" + dt + "')]"));
		waitForElementToBePresent(By.xpath("//td[contains(text(),'Graded')]/following-sibling::td[contains(text(),'" + dt + "')]"));
		waitForElementToBePresent(By.xpath("//td[contains(text(),'Admin User')]"));
		
		
		return this;
	}
	
	public FacilitationManagerDashboardPage verifyTableIspresent() throws Throwable {
		waitForElementToBeVisibile(table);
		waitForElementToBeClickable(table);
		return this;
	}
	
	
	public FacilitationManagerDashboardPage gradeAssignment() throws Throwable {
		Thread.sleep(2000);
		String currentWindow = BrowserFactory.getDriver().getWindowHandle();
		for(String winHandle : BrowserFactory.getDriver().getWindowHandles()){
			   if (BrowserFactory.getDriver().switchTo().window(winHandle).getTitle().contains("Assignment:")) {
				  clickOneOfTheGrade();
				  clicksaveChangesButton();
				  Thread.sleep(3000);
				  try{
					  waitForElementToBeVisibile(gradedText);
				  if(gradedText.isDisplayed()==false){ 
				  }
				  }
				  catch(Exception e){ 
					  clickOneOfTheGrade();
					  clicksaveAndShowNewButton(); 
					  waitForElementToBePresent(By.cssSelector("input[value='Ok']"));
					  waitForElementToBeClickable(By.cssSelector("input[value='Ok']"));
					  WebElement ele=BrowserFactory.getDriver().findElement(By.cssSelector("input[value='Ok']"));
					  ele.click();
					  
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
	
	public FacilitationManagerDashboardPage gradeAssignment2() throws Throwable {
		 ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	            }};
	     WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
	     wait.until(expectation);
		 clickOneOfTheGrade();
		 wait.until(expectation);
		 Thread.sleep(2000);
		 clicksaveChangesButton();
		 wait.until(expectation);
		  Thread.sleep(3000);
		  try{  
			  waitForElementToBeVisibile(gradedText);
		  }
		  catch(Exception e){ 
			  clickOneOfTheGrade();
			  clicksaveChangesButton();
			  waitForElementToBePresent(By.cssSelector("input[value='Ok']"));
			  waitForElementToBeClickable(By.cssSelector("input[value='Ok']"));
			  WebElement ele=BrowserFactory.getDriver().findElement(By.cssSelector("input[value='Ok']"));
			  ele.click();
			  
		  }
		  
		  waitForElementToBeVisibile(gradedText);
		  BrowserFactory.getDriver().close();
	     
	
					 
			
		return this;
	}
	
	public FacilitationManagerDashboardPage clickOneOfTheGrade() throws Throwable {
		waitForElementToBeVisibile(gradeMaximiseButton);
		waitForElementToBeClickable(gradeMaximiseButton);
		gradeMaximiseButton.click();
		waitForElementToBePresent(By.cssSelector("tr[role='radiogroup']"));
		waitForElementToBeClickable(By.cssSelector("tr[role='radiogroup']"));
		List <WebElement> elements=BrowserFactory.getDriver().findElements(By.cssSelector("tr[role='radiogroup']"));
		for(int i=1;i<=elements.size();i++){	
			Thread.sleep(2000);
			waitForElementToBePresent(By.xpath("((//tr[@role='radiogroup'])[" + i + "]//td)[4]"));
			waitForElementToBeClickable(By.xpath("((//tr[@role='radiogroup'])[" + i + "]//td)[4]"));
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
		waitForElementToBePresent(By.xpath("(//table//tbody//tr//td[contains(text(),'Graded')])[2]"));
		waitForElementToBePresent(By.xpath("(//table//tbody//tr//td[contains(text(),'Graded')])[3]"));
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
	
	public FacilitationManagerDashboardPage verifyUserSignedOff() throws Throwable {
		waitForElementToBeVisibile(signedOffText);
		waitForElementToBeClickable(signedOffText);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		WebElement ele=BrowserFactory.getDriver().findElement(By.xpath("//table[@class='table']//tbody//tr//td[contains(text(),'Signed-off')]/following-sibling::td[contains(text(),'" + dateFormat.format(date) + "')]"));
		waitForElementToBeVisibile(ele);
		return this;
	}

}
