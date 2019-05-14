package com.netsuite.tlh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;


public class RightNavBar extends BasePage {

	public RightNavBar() throws DriverNotInitializedException {
		super();
	}

	@FindBy(css = "a[title='Understanding Our Universe: An Introduction to Astronomy']")
	private WebElement fitnessPovCourse;
	
	@FindBy(xpath = "//h1[text()='Health, Wellness, and Fitness: A New Look']")
	private WebElement fitnessPovCoursePageHeading;
	
	@FindBy(css = "i[class='icon fa fa-file-zip-o fa-fw navicon']")
	private WebElement backUpLink;
	
	@FindBy(xpath = "//h1[contains(text(),'Backup course:')]")
	private WebElement backUpCoursePageHeading;
	
	@FindBy(xpath = "//a[text()='Participants']")
	private WebElement participantsLink;
	
	@FindBy(xpath = "//p//a[text()='Courses']")
	private WebElement coursesLink;
	
	@FindBy(xpath = "//a[contains(text(),'Assignments')]")
	private WebElement assignmentsLink;
	
	@FindBy(xpath = "//*[text()='Facilitation Manager Dashboard']")
	private WebElement facilitationManagerDashboardLink;
	
	@FindBy(xpath = "//*[text()='Facilitation Dashboard']")
	private WebElement facilitationDashboardLink;
	
	@FindBy(xpath = "//span[contains(text(),'Site administration')]")
	private WebElement siteAdministrationLink;
	
	@FindBy(xpath = "//p[@id='courses_tree_item']//span[contains(text(),'Courses')]")
	private WebElement siteAdministrationCourseLink;
	
	@FindBy(xpath = "//span[contains(text(),'Restore course')]")
	private WebElement siteAdministrationRestoreCourseLink;
	
	@FindBy(xpath = "//p//a[contains(text(),'Course completion')]//i")
	private WebElement courseCompletionLink;
	
	@FindBy(xpath = "//a[contains(text(),'Quizzes')]")
	private WebElement quizzesLink;
	
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	private WebElement HomeLink;
	
	public RightNavBar clickOnHomeLink() throws Throwable {
		
		waitForElementToBeVisibile(HomeLink);
		waitForElementToBeClickable(HomeLink);
		HomeLink.click();
		return this;
	}
	
	public RightNavBar clickOnQuizzesLink() throws Throwable {	
		waitForElementToBeVisibile(quizzesLink);
		waitForElementToBeClickable(quizzesLink);
		quizzesLink.click();
		return this;
	}
	
	
	public RightNavBar clickcourseCompletionLink() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		waitForElementToBeVisibile(courseCompletionLink);
		waitForElementToBeClickable(courseCompletionLink);
		courseCompletionLink.sendKeys(Keys.ENTER);
		return this;
	}

	public RightNavBar clickOnFitnessPovCourse() throws Throwable {
		waitForElementToBeVisibile(fitnessPovCourse);
		fitnessPovCourse.click();
		return this;
	}
	public RightNavBar verifyUserIsOnFitnessPovCoursePage() throws Throwable {
		waitForElementToBeVisibile(fitnessPovCourse);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isElementDisplayed(fitnessPovCoursePageHeading),
				"fitnessPovCoursePageHeading is NOT displayed");
		softAssert.assertAll();
		return this;
	}
	
	public RightNavBar clickOnBackupLink() throws Throwable {
		waitForElementToBeVisibile(backUpLink);
		backUpLink.click();
		return this;
	}

	public RightNavBar verifyUserIsOnBackupCoursePage() throws Throwable {
		waitForElementToBeVisibile(backUpCoursePageHeading);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isElementDisplayed(backUpCoursePageHeading),
				"backUpCoursePageHeading is NOT displayed");
		softAssert.assertAll();
		return this;
	}
	
	public RightNavBar clickOnParticipants() throws Throwable {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }};
            WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
    		wait.until(expectation);
		waitForElementToBeVisibile(participantsLink);
		waitForElementToBeClickable(participantsLink);
		participantsLink.sendKeys(Keys.ENTER);
		return this;
	}
	
	public RightNavBar clickOnCourses() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		Thread.sleep(2000);
		waitForElementToBeVisibile(coursesLink);
		waitForElementToBeClickable(coursesLink);
		Actions act= new Actions(BrowserFactory.getDriver());
		act.moveToElement(coursesLink).click().build().perform();
		//coursesLink.click();
		return this;
	}
	
	public RightNavBar clickOnCourse(String course) throws Throwable {
		WebElement courseLink= BrowserFactory.getDriver().findElement(By.xpath("//p//a[text()='" + course + "']"));
		waitForElementToBeVisibile(courseLink);
		waitForElementToBeClickable(courseLink);
		courseLink.click();
		return this;
	}
	
	public RightNavBar clickOnApostopheCourse() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		waitForElementToBePresent(By.xpath("//p//a[contains(text(),'moodle')]"));
		waitForElementToBeClickable(By.xpath("//p//a[contains(text(),'moodle')]"));
		BrowserFactory.getDriver().findElement(By.xpath("//p//a[contains(text(),'moodle')]")).click();	
		return this;
	}

	public RightNavBar clickOnAssignments() throws Throwable {
		
		waitForElementToBeVisibile(assignmentsLink);
		waitForElementToBeClickable(assignmentsLink);
		assignmentsLink.sendKeys(Keys.ENTER);
		return this;
	}
	
	public RightNavBar clickOnFacilitationManagerDashboardLink() throws Throwable {
		
		waitForElementToBeVisibile(facilitationManagerDashboardLink);
		waitForElementToBeClickable(facilitationManagerDashboardLink);
		facilitationManagerDashboardLink.click();
		return this;
	}
	
	public RightNavBar clickOnFacilitationDashboardLink() throws Throwable {
		
		waitForElementToBeVisibile(facilitationDashboardLink);
		waitForElementToBeClickable(facilitationDashboardLink);
		facilitationDashboardLink.click();
		return this;
	}

	public RightNavBar clickOnSiteAdministrationLink() throws Throwable {
		waitForElementToBeVisibile(siteAdministrationLink);
		siteAdministrationLink.click();
		return this;
	}
	
	public RightNavBar clickOnSiteAdministrationCourseLink() throws Throwable {
		waitForElementToBeVisibile(siteAdministrationCourseLink);
		siteAdministrationCourseLink.click();
		return this;
		}
	
	public RightNavBar clickOnSiteAdministrationRestoreCourseLink() throws Throwable {
		waitForElementToBeVisibile(siteAdministrationRestoreCourseLink);
		siteAdministrationRestoreCourseLink.click();
		return this;
		}
	
}
