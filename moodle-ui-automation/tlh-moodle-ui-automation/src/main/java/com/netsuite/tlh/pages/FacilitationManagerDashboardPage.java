package com.netsuite.tlh.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.testdata.CreateBackupData;

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
	
	@FindBy(id = "fecthData")
	private WebElement fetchDataButton;
	
	@FindBy(id = "deleteSubmissionId")
	private WebElement deleteSubmissionButton;
	
	@FindBy(xpath = "//li//a[@aria-label='Next']")
	private WebElement dashboardNextButton;
	
	@FindBy(xpath = "//td[text()='Required: Participation Acknowledgement']")
	private WebElement participationAcknowledgementText;
	
	@FindBy(xpath = "//td[text()='Module 2 Project Checkpoint']")
	private WebElement module2Checkpoint;
	
	@FindBy(xpath = "//td[text()='Module 3 Project Checkpoint']")
	private WebElement module3Checkpoint;
	
	@FindBy(xpath = "//td[text()='Final Project Submission']")
	private WebElement finalProjectSubmision;
	Boolean stat= true;
	
	public FacilitationManagerDashboardPage verifyRubricGradingMain() throws Throwable {
		waitForElementToBeVisibile(previoudGrades);
		waitForElementToBeVisibile(previoudGradesTable);
		Assert.assertEquals(participationAcknowledgementText.isDisplayed(), true);
		Assert.assertEquals(module2Checkpoint.isDisplayed(), true);
		Assert.assertEquals(module3Checkpoint.isDisplayed(), true);
		Assert.assertEquals(finalProjectSubmision.isDisplayed(), true);
		
		return this;
	}
	
	public FacilitationManagerDashboardPage verifyRubricGrading() throws Throwable {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver driver) {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"); }};
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
        //Code starts from here
        Thread.sleep(2000);
        String currentWindow = BrowserFactory.getDriver().getWindowHandle();
        WebElement element=BrowserFactory.getDriver().findElement(By.xpath("//table[@class='table']//tbody//td[3]//a"));
		  waitForElementToBeClickable(element);
		  element.sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
		
		for(String winHandle : BrowserFactory.getDriver().getWindowHandles()){
		 if (BrowserFactory.getDriver().switchTo().window(winHandle).getTitle().contains("Assignment:")) {
		wait.until(expectation);
		verifyRubricGradingMain();
		 BrowserFactory.getDriver().close();
		 break;
			   } 
		BrowserFactory.getDriver().switchTo().window(currentWindow);
		}
		BrowserFactory.getDriver().switchTo().window(currentWindow);
		return this;
	}
	
	
	public FacilitationManagerDashboardPage getDashboardAssignmentCount() throws Throwable {
		
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"); }};
            WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
		int count=0;
		
		List<WebElement> ele3= BrowserFactory.getDriver().findElements(By.xpath("//ul[@class='pagination']//li"));
		
		for(int i=0;i<=ele3.size();i++){
			List<WebElement> Page= BrowserFactory.getDriver().findElements(By.xpath("//table[@class='table']//tbody//tr"));
			System.out.println("Count at page: "+i+" "+Page.size());
			count=count+Page.size();
			waitForElementToBeClickable(dashboardNextButton);
			dashboardNextButton.click();
			wait.until(expectation);
			
			WebElement ele= BrowserFactory.getDriver().findElement(By.xpath("//ul[@class='pagination']//li[@class='active']"));
			WebElement ele2= BrowserFactory.getDriver().findElement(By.xpath("(//ul[@class='pagination']//li)[last()-2]"));
			
			
			if(ele.equals(ele2)){
				List<WebElement> PageLast= BrowserFactory.getDriver().findElements(By.xpath("//table[@class='table']//tbody//tr"));
				count=count+PageLast.size();
				break;
			}	
		}
		System.out.println("Count "+count);
            
		return this;
	}
	
	public FacilitationManagerDashboardPage clickOnDeleteSubmissionButton() throws Throwable {
		waitForElementToBeVisibile(deleteSubmissionButton);
		waitForElementToBeClickable(deleteSubmissionButton);
		deleteSubmissionButton.click();
		Thread.sleep(1000);
		Alert alert = BrowserFactory.getDriver().switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		return this;
	}
	
	public FacilitationManagerDashboardPage verifySignOffButtonIsNotPresent() throws Throwable {
		List<WebElement> dynamicElement= BrowserFactory.getDriver().findElements(By.cssSelector("a[class='btn btn-primary signoff-button']"));
		if(dynamicElement.size() == 0)
		Assert.assertEquals("True", "True");
		else
			Assert.assertEquals("False", "True");	
		return this;
	}
	
	public FacilitationManagerDashboardPage clickOnFetchData() throws Throwable {
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
	
	public FacilitationManagerDashboardPage verifyAssignmentIsGraded(String Username) throws Throwable {
		waitForElementToBeVisibile(filterButton);
		waitForElementToBeClickable(filterButton);
		waitForElementToBePresent(By.xpath("//td[text()='" + Username + "']/ancestor::tr//td[text()='Graded']"));

		return this;
	}
	
	public FacilitationManagerDashboardPage verifyGrader(String Student, String Facilitator) throws Throwable {
		waitForElementToBeVisibile(filterButton);
		waitForElementToBeClickable(filterButton);
		waitForElementToBePresent(By.xpath("//td[text()='" + Student + "']/ancestor::tr//td[text()='" + Facilitator + "']"));

		return this;
	}
	
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
		
		waitForElementToBeClickable(dateSubmittedInput);
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
	
	public FacilitationManagerDashboardPage verifyOriginalGraderFilter(String Status) throws Throwable {
		waitForElementToBeVisibile(table);
		waitForElementToBeClickable(table);
		List <WebElement> ele= BrowserFactory.getDriver().findElements(By.xpath("//table[@class='table']//tbody//tr//td[5]"));
		
		for(int i=1;i<ele.size();i++){
			String res=BrowserFactory.getDriver().findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td[5]")).getText();
			if(!res.equalsIgnoreCase(Status)){
				Assert.assertEquals("False", "True");
			}
		}		
		return this;
	}
	
	public FacilitationManagerDashboardPage refreshPage() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		return this;
	}
	
	public FacilitationManagerDashboardPage getDashboardFetchDataTimeStamp() throws Throwable {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }};
		waitForElementToBeVisibile(tableData);
		long start=System.currentTimeMillis();
		fetchDataButton.click();
		WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
		wait.until(expectation);
		long finish=System.currentTimeMillis();
		long totalTime=finish- start;
		System.out.println("TotalTime taken for Dashboard after fetch Button is clicked  = "+ totalTime +" milli Second");
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
	
	public FacilitationManagerDashboardPage openAssigmentsLink(CreateBackupData createBackupData, int Count) throws Throwable {
		waitForElementToBeVisibile(table);
		waitForElementToBeClickable(table);
		Thread.sleep(1000);
	  for(int i=1;i<=Count;i++){
		  
		  WebElement element=BrowserFactory.getDriver().findElement(By.xpath("//td[@class='text-danger bold']/ancestor::tr//td[3]//a"));
		  waitForElementToBeClickable(element);
		  element.sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
		  if(i==2){
			  Thread.sleep(2000);
				String currentWindow = BrowserFactory.getDriver().getWindowHandle();
				for(String winHandle : BrowserFactory.getDriver().getWindowHandles()){
					   if (BrowserFactory.getDriver().switchTo().window(winHandle).getTitle().contains("Assignment:")) {
						   ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
					            public Boolean apply(WebDriver driver) {
					                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
					            }};

					WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
							wait.until(expectation);
							Thread.sleep(4000);
						  // verifyRubricView();   	   
					   }}  
				BrowserFactory.getDriver().switchTo().window(currentWindow);
		  }
		  ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	            }};
		  WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
			wait.until(expectation);
		  gradeAssignment()
		  .clickOnFetchData()
		  .selectDateSubmitted()
		  .enterCourseCode(createBackupData.getCourseShortName())
		  .clickFilterButton();
		 
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
				   ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			            public Boolean apply(WebDriver driver) {
			                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			            }};

			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
					wait.until(expectation);
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
		//waitForElementToBePresent(By.xpath("//td[contains(text(),'Admin User')]"));
		
		
		return this;
	}
	
	public FacilitationManagerDashboardPage verifyTableIspresent() throws Throwable {
		waitForElementToBeVisibile(table);
		waitForElementToBeClickable(table);
		return this;
	}
	
	public FacilitationManagerDashboardPage verifyCourseCodeValidations() throws Throwable {
		waitForElementToBeVisibile(table);
		waitForElementToBeClickable(table);
		String Name= ParticipantsPage.Name;
		List <WebElement> ele=BrowserFactory.getDriver().findElements(By.xpath("//table[@class='table']//tbody//tr//td[1]"));
		for(int i=1;i<ele.size();i++){
			String res=BrowserFactory.getDriver().findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td[1]")).getText();
			if(!Name.equalsIgnoreCase(res)){
				Assert.assertEquals("False", "True");
			}
		}	
		return this;
	}
	
	public FacilitationManagerDashboardPage verifyNoGradedAssignmentIspresent() throws Throwable {
		List<WebElement> ele= BrowserFactory.getDriver().findElements(By.cssSelector("td[class='graded']"));
		if(ele.size()==0){
		    Assert.assertEquals("Passed", "Passed");
		 } else {
			 Assert.assertEquals("Fail","Passed");
		 }
		return this;
	}
	
	public FacilitationManagerDashboardPage verifyFacilitatorIsEnrolled() throws Throwable {
		List<WebElement> ele= BrowserFactory.getDriver().findElements(By.xpath("//table[@class='table']//tbody//td[7]"));
		for(int i=0;i<ele.size();i++){
			if(ele.get(i).getText().equalsIgnoreCase(null)){
				Assert.assertEquals("Fail","Passed");
			}}
		return this;
	}
	
	public FacilitationManagerDashboardPage verifyCourseCodeValidation() throws Throwable {
		
		return this;
	}
	
	public FacilitationManagerDashboardPage verifyProperSignOffStatus(String Status) throws Throwable {
		
		if(Status.equalsIgnoreCase("Signed-off")){
			List<WebElement> ele= BrowserFactory.getDriver().findElements(By.xpath("//a[text()='Sign Off']"));
			if(ele.size()==0){
			    Assert.assertEquals("Passed", "Passed");
			 } else {
				 Assert.assertEquals("Fail","Passed");
			 }
		}
		if(Status.equalsIgnoreCase("Awaiting Sign-off")){
			List<WebElement> ele= BrowserFactory.getDriver().findElements(By.xpath("//td[text()='Signed-off']"));
			if(ele.size()==0){
			    Assert.assertEquals("Passed", "Passed");
			 } else {
				 Assert.assertEquals("Fail","Passed");
			 }
		}
		
		
		return this;
	}
	
	
	public FacilitationManagerDashboardPage gradeAssignment() throws Throwable {
		Thread.sleep(2000);
		String currentWindow = BrowserFactory.getDriver().getWindowHandle();
		for(String winHandle : BrowserFactory.getDriver().getWindowHandles()){
			   if (BrowserFactory.getDriver().switchTo().window(winHandle).getTitle().contains("Assignment:")) {
				   ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			            public Boolean apply(WebDriver driver) {
			                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			            }};

			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
					wait.until(expectation);
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
	     Thread.sleep(3000);
		 clicksaveChangesButton();
		 wait.until(expectation);
		  try{  
			  waitForElementToBeVisibile(gradedText);
		  }
		  catch(Exception e){ 
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
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }};

            WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
		wait.until(expectation);
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
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }};
            
            WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
    		wait.until(expectation);
		waitForElementToBeVisibile(signedOffText);
		waitForElementToBeClickable(signedOffText);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		WebElement ele=BrowserFactory.getDriver().findElement(By.xpath("//table[@class='table']//tbody//tr//td[contains(text(),'Signed-off')]/following-sibling::td[contains(text(),'" + dateFormat.format(date) + "')]"));
		waitForElementToBeVisibile(ele);
		return this;
	}

}
