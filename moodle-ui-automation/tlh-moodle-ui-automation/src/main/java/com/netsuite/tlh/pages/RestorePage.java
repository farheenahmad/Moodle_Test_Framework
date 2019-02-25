package com.netsuite.tlh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;


public class RestorePage extends BasePage {

	public RestorePage() throws DriverNotInitializedException {
		super();
	}

	@FindBy(xpath = "(//a[contains(text(),'Restore')])[3]")
	private WebElement restoreLink;
	
	@FindBy(css = "button[type='submit']")
	private WebElement bottomcontinueButton;
	
	@FindBy(css = "input[value='Continue']")
	private WebElement continueButton;
	
	@FindBy(css = "tr[class='rcs-course dimmed']>td>input[name='targetid'][value='1']")
	private WebElement miscellaneousOption;
	
	@FindBy(css = "input[id='id_submitbutton']")
	private WebElement nextButton;
	
	@FindBy(css = "input[id='id_setting_course_course_fullname_value']")
	private WebElement courseNameInput;
	
	@FindBy(css = "input[id='id_setting_course_course_shortname_value']")
	private WebElement courseShortNameInput;
	
	@FindBy(css = "input[value='Perform restore']")
	private WebElement performRestoreButton;
	
	@FindBy(css = "input[name='backupfilechoose']")
	private WebElement chooseFileButton;
	
	@FindBy(css = "input[name='repo_upload_file']")
	private WebElement uploadFileOption;
	
	@FindBy(css = "button[class='fp-upload-btn btn-primary btn']")
	private WebElement uploadThisFileButton;
	
	@FindBy(css = "input[name='submitbutton']")
	private WebElement restoreButton;
	
	@FindBy(css = "input[id='id_setting_root_users']")
	private WebElement enrolledUserCheckBox;
	
	public RestorePage clickOnRestoreButton() throws Throwable {
		waitForElementToBeClickable(restoreButton);
		waitForElementToBeVisibile(restoreButton);
		restoreButton.click();
		return this;
	}
	
	public RestorePage clickOnchooseFileButton() throws Throwable {
		waitForElementToBeClickable(chooseFileButton);
		waitForElementToBeVisibile(chooseFileButton);
		chooseFileButton.click();
		return this;
	}
	
	public RestorePage uploadFile() throws Throwable {
		waitForElementToBeClickable(uploadFileOption);
		waitForElementToBeVisibile(uploadFileOption);
		uploadFileOption.sendKeys(System.getProperty("user.dir")+"/src/test/resources/testdata/backup-moodle2-course-1401-thepsychofspor-ce-pov-20190107-1229.mbz");
		return this;
	}
	
	public RestorePage clickOnUploadThisFileButton() throws Throwable {
		waitForElementToBeClickable(uploadThisFileButton);
		waitForElementToBeVisibile(uploadThisFileButton);
		uploadThisFileButton.click();
		return this;
	}
	
	public RestorePage clickOnRestoreLink() throws Throwable {
		waitForElementToBeClickable(restoreLink);
		waitForElementToBeVisibile(restoreLink);
		restoreLink.click();
		return this;
	}
	
	public RestorePage clickOnBottomContinueButton() throws Throwable {
		waitForElementToBeClickable(bottomcontinueButton);
		waitForElementToBeVisibile(bottomcontinueButton);
		bottomcontinueButton.click();
		return this;
	}
	
	public RestorePage clickOnMiscellaneousOption() throws Throwable {
		waitForElementToBeClickable(miscellaneousOption);
		waitForElementToBeVisibile(miscellaneousOption);
		miscellaneousOption.click();
		return this;
	}
	
	
	public RestorePage clickOnContinueButton() throws Throwable {
		waitForElementToBeClickable(continueButton);
		waitForElementToBeVisibile(continueButton);
		continueButton.click();
		return this;
	}
	
	public RestorePage clickOnNextButton() throws Throwable {
		waitForElementToBeClickable(nextButton);
		waitForElementToBeVisibile(nextButton);
		nextButton.click();
		return this;
	}
	
	public RestorePage enterCourseName(String CourseName) throws Throwable {
		waitForElementToBeClickable(courseNameInput);
		waitForElementToBeVisibile(courseNameInput);
		courseNameInput.clear();
		courseNameInput.sendKeys(CourseName);
		return this;
	}

	public RestorePage enterCourseShortName(String CourseShortName) throws Throwable {
		waitForElementToBeClickable(courseShortNameInput);
		waitForElementToBeVisibile(courseShortNameInput);
		courseShortNameInput.clear();
		courseShortNameInput.sendKeys(CourseShortName);
		return this;
	}
	
	public RestorePage clickOnPerformRestore() throws Throwable {
		waitForElementToBeClickable(performRestoreButton);
		waitForElementToBeVisibile(performRestoreButton);
		performRestoreButton.click();
		return this;
	}
	
	public RestorePage removeEnrolledUser() throws Throwable {
		waitForElementToBeClickable(enrolledUserCheckBox);
		waitForElementToBeVisibile(enrolledUserCheckBox);
		enrolledUserCheckBox.click();
		return this;
	}
	
}
