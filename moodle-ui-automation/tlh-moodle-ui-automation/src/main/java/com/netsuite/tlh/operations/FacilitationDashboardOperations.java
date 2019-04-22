package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.FacilitationDashboardPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class FacilitationDashboardOperations extends BaseOperations {
	
	public FacilitationDashboardOperations verifyFilters(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		
		NetsuiteTLHPageFactory.getPage(FacilitationDashboardPage.class).clickOnFetchData()
		
		.enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.enterCourseName(createBackupData.getCourseName()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.enterAssignmentName(createBackupData.getAssignmentName()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatus()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusUngraded()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAll()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAwaiting()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusSigned()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.expectedCompletionDateInput().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		;
		
		return this;	
	}
	
	
	
}
