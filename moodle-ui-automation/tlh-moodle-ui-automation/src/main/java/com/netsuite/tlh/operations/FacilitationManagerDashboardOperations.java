package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.FacilitationDashboardPage;
import com.netsuite.tlh.pages.FacilitationManagerDashboardPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class FacilitationManagerDashboardOperations extends BaseOperations {
	
	public FacilitationManagerDashboardOperations gradeAssigment(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().clickFilterButton()
		.openAssigmentsLink().selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().checkIfGraded()
		.verifyGradedUngradedFilters();
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeAssigment2(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted()
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).clickFilterButton()
		.openAssigmentsLink2().selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().checkIfGraded()
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
	
	public FacilitationManagerDashboardOperations verifyResubmittedAssignment() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).verifyTableIspresent().verifyResubmitedAssignment();
		
		return this;	
	}
	
	
	public FacilitationManagerDashboardOperations verifyDateGradedFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateGraded()
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton();
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyOriginalGraderFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectAssignmentStatus(createBackupData.getStatusAll())
		.enterOriginalGraderName(createBackupData.getUserName3()).clickFilterButton().verifyOriginalGraderFilter(createBackupData.getStatus())
		.verifyGradedUngradedFilters();
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyCourseCodeFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickResetButton().enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().verifyCourseCodeValidations()
		
		
		;
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyFilters(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		
		.enterFacilitatorName(createBackupData.getFacilitatorName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().verifyFacilitatorIsEnrolled().clickResetButton()
		
		.enterStudentName(createBackupData.getUserName1()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterAssignmentName(createBackupData.getAssignmentName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectDateSubmitted().selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().verifyCourseCodeValidation().clickResetButton()
		
		.enterCourseName(createBackupData.getCourseName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAll()).clickFilterButton().verifyTableIspresent()
		.verifyProperSignOffStatus(createBackupData.getSignOffStatusAll()).clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAwaiting()).clickFilterButton().verifyTableIspresent()
		.verifyProperSignOffStatus(createBackupData.getSignOffStatusAwaiting()).clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusSigned()).clickFilterButton().verifyTableIspresent()
		.verifyProperSignOffStatus(createBackupData.getSignOffStatusSigned()).clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusUngraded()).clickFilterButton().verifyTableIspresent()
		.verifyNoGradedAssignmentIspresent().clickResetButton()
		
		.expectedCompletionDateInput().clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.enterOriginalGraderName(createBackupData.getOriginalGraderName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectCourseStartDate().clickFilterButton().verifyTableIspresent().clickResetButton()
		
		;
		
		return this;	
	}
	
}
