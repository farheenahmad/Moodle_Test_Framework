package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.FacilitationDashboardPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class FacilitationDashboardOperations extends BaseOperations {
	
	public FacilitationDashboardOperations verifyFilters(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		
		NetsuiteTLHPageFactory.getPage(FacilitationDashboardPage.class)
		
		.enterStudentName(createBackupData.getUserName1()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.selectDateSubmitted().selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		//.enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.enterCourseName(createBackupData.getCourseName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.enterAssignmentName(createBackupData.getAssignmentName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusUngraded()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAll()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAwaiting()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusSigned()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		//.expectedCompletionDateInput().clickFilterButton().verifyTableIspresent().clickResetButton()
		
		;
		
		return this;	
	}
	
	
	
}
