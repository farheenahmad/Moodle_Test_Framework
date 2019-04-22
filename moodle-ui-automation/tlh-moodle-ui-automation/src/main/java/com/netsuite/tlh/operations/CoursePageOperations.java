package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.CoursePage;
import com.netsuite.tlh.testdata.CreateBackupData;


public class CoursePageOperations extends BaseOperations {
	
	public CoursePageOperations deleteRespectiveCourse() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickManageCourseButton().clickDeleteCourseButton().clickDeleteButton()
		.clickContinueButton();
		return this;	
	}
	
	public CoursePageOperations clickTurnEditingOn() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickturnEditingOnLink();
		return this;	
	}
	
	public CoursePageOperations changeCourseName(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickOncourseNameSettings().clickOncourseNameEditSettings()
		.changeCourseFullNameInputBox(createBackupData.getCourseName2()).clickSaveAndDisplayButton();
		;
		return this;	
	}
	
	public CoursePageOperations changeAssignmentName(String Module,String NewName) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickOnEditLinkforCourse(Module).clickOnEditSettings(Module)
		.changeAssignmentName(NewName).clicksaveAndReturnCourseButton()
		;
		return this;	
	}
	
	public CoursePageOperations verifyCheckPoints() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(CoursePage.class).verifyCheckPoints().clickModule2ProjectCheckpointLink()
		.clickEditSubmissionButton().clickAddButton().uploadAFile();
		return this;	
	}
	
	public CoursePageOperations clickTurnEditingOff() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickturnEditingOffLink();
		return this;	
	}
	
	public CoursePageOperations doActivityCompletion(String Module,CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickOnEditLinkforCourse(Module).
		clickOnEditSettings(Module).clickActivityCompletionHeader().selectCompletionTracking(createBackupData.getActivityDetails())
		.clickcompleteGradeCheckBox().clicksubmitActivityCheckBox().clicksaveAndReturnCourseButton();
		return this;	
	}
	
	public CoursePageOperations doParticipationAcknowledgement(String Module,CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickOnEditLinkforCourse(Module).
		clickOnEditSettings(Module).clickActivityCompletionHeader().selectCompletionTracking(createBackupData.getActivityDetails())
		.clickcompleteGradeCheckBox().clicksaveAndReturnCourseButton();
		return this;	
	}
	
	public CoursePageOperations doCourseCompletion(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(CoursePage.class).selectCompletionRequirements(createBackupData.getCompletionRequirement())
		.clickActivityCompletionHeader2().clickSelectAll().clickSaveChangesButton()
		;
		return this;	
	}
	
	public CoursePageOperations completeParticipationAcknowledgement(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickparticipationAcknowledgementLink().clickattemptQuizNowButton()
		.clickQuizAnswerOption().clickfinishAttemptButton().clicksubmitAllAndFinishButton().clickfinishReviewLink()
		;
		return this;	
	}
	
	public CoursePageOperations completeParticipationAcknowledgement2() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickParticipationAcknowledgementLink().clickattemptQuizNowButton()
		.clickQuizAnswerOption().clickfinishAttemptButton().clicksubmitAllAndFinishButton().clickfinishReviewLink()
		;
		return this;	
	}
	
}
