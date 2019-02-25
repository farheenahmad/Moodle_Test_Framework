package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.RestorePage;
import com.netsuite.tlh.testdata.CreateBackupData;


public class RestorePageOperations extends BaseOperations {

	public RestorePageOperations DoTheRestore(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RestorePage.class).clickOnRestoreLink().clickOnBottomContinueButton()
		.clickOnMiscellaneousOption().clickOnContinueButton().clickOnNextButton().enterCourseName(createBackupData.getCourseName())
		.enterCourseShortName(createBackupData.getCourseShortName()).clickOnNextButton().clickOnPerformRestore().clickOnBottomContinueButton();
		return this;
		
	}
	
	public RestorePageOperations DoTheRestore2(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RestorePage.class).clickOnchooseFileButton().uploadFile().clickOnUploadThisFileButton()
		.clickOnRestoreButton().clickOnBottomContinueButton().clickOnMiscellaneousOption().clickOnContinueButton().removeEnrolledUser().clickOnNextButton()
		.enterCourseName(createBackupData.getCourseName()).enterCourseShortName(createBackupData.getCourseShortName())
		.clickOnNextButton().clickOnPerformRestore().clickOnBottomContinueButton();
		return this;
		
	}
	
	
	
	
}