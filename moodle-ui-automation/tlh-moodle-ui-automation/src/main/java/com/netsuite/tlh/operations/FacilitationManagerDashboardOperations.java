package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.FacilitationDashboardPage;
import com.netsuite.tlh.pages.FacilitationManagerDashboardPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class FacilitationManagerDashboardOperations extends BaseOperations {
	
	public FacilitationManagerDashboardOperations gradeAssigment(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().clickFilterButton()
		.openAssigmentsLink()
		
		.selectAssignmentStatus(createBackupData.getStatus())
		.clickFilterButton().checkIfGraded()
		
		.verifyGradedUngradedFilters()
		;
		return this;	
	}
	
	public FacilitationManagerDashboardOperations getRefreshDashboardPerformance() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).getDashboardRefreshTimeStamp();
		return this;	
	}
	
	public FacilitationManagerDashboardOperations getGradedFilterDashboardPerformance(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectAssignmentStatus(createBackupData.getStatus())
		.getGradedFilterTimeStamp();
		return this;	
	}
	
	public FacilitationManagerDashboardOperations getLoadingDashboardPerformance() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).getDashboardLoadingTimeStamp();
		return this;	
	}
	
	public FacilitationManagerDashboardOperations signOff(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).refreshPage().selectDateSubmitted().selectAssignmentStatus(createBackupData.getStatus())
		.clickFilterButton().checkIfGraded().clickOnSignOffButton().verifyUserSignedOff();
		return this;	
	}
	
	
	public FacilitationManagerDashboardOperations verifyDateGradedFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateGraded().selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton();
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyFilters(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		
		.enterFacilitatorName(createBackupData.getFacilitatorName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterStudentName(createBackupData.getUserName1()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterAssignmentName(createBackupData.getAssignmentName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectDateSubmitted().selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.enterCourseName(createBackupData.getCourseName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAll()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAwaiting()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusSigned()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusUngraded()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.expectedCompletionDateInput().clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.enterOriginalGraderName(createBackupData.getOriginalGraderName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectCourseStartDate().clickFilterButton().verifyTableIspresent().clickResetButton()
		
		;
		
		return this;	
	}
	
}
