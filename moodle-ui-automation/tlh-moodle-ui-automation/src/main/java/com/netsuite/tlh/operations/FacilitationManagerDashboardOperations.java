package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.FacilitationDashboardPage;
import com.netsuite.tlh.pages.FacilitationManagerDashboardPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class FacilitationManagerDashboardOperations extends BaseOperations {
	
	public FacilitationManagerDashboardOperations ClickFetchDataButton() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickOnFetchData()
		;
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeAssigment(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		
		.selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().clickOnFetchData()
		
		.selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		
		.openAssigmentsLink(createBackupData,3)
		
		
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().checkIfGraded().verifyGradedUngradedFilters();
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeAssigment3(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickOnFetchData().selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.openAssigmentsLink( createBackupData,2)
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().checkIfGraded()
		;
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeAssigment2(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickOnFetchData().selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).clickFilterButton()
		.openAssigmentsLink2().clickOnFetchData().selectAssignmentStatus(createBackupData.getStatus()).selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().checkIfGraded()
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
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickOnFetchData().selectDateSubmitted().selectAssignmentStatus(createBackupData.getStatus())
		.enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().checkIfGraded().clickOnSignOffButton().clickOnFetchData().selectDateSubmitted().selectAssignmentStatus(createBackupData.getStatus())
		.clickFilterButton().verifyUserSignedOff();
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifySignOffFunctionality() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).verifySignOffButtonIsNotPresent();
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyResubmittedAssignment(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).verifyTableIspresent().clickOnFetchData()
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).clickFilterButton()
		.verifyResubmitedAssignment();
		
		return this;	
	}
	
	
	public FacilitationManagerDashboardOperations verifyDateGradedFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickOnFetchData().selectDateGraded()
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton();
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyAssignmentIsGraded(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickOnFetchData().selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyAssignmentIsGraded(createBackupData.getUserName4());
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyGrader(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickOnFetchData().enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton()
		.verifyGrader(createBackupData.getUserName4(), createBackupData.getUserName5());
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyOriginalGraderFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickOnFetchData().selectAssignmentStatus(createBackupData.getStatusAll())
		.enterOriginalGraderName(createBackupData.getUserName3()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyOriginalGraderFilter(createBackupData.getStatus())
		.verifyGradedUngradedFilters();
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyCourseCodeFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickOnFetchData().clickResetButton().enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().verifyCourseCodeValidations()
		;
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyApostopheFilters(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickOnFetchData()
		
		.enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterCourseName(createBackupData.getCourseName()).enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterAssignmentName(createBackupData.getModule2Newname()).enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterAssignmentName(createBackupData.getModule3NewName()).enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterStudentName(createBackupData.getUserName4()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		;
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyApostopheFilters2(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickOnFetchData()
		
		.enterCourseName(createBackupData.getCourseName2()).enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		
		
		;
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyFilters(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickOnFetchData()
		
		.enterFacilitatorName(createBackupData.getFacilitatorName()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().verifyFacilitatorIsEnrolled().clickResetButton()
		
		.enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterAssignmentName(createBackupData.getAssignmentName()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterCourseCode(createBackupData.getCourseShortName()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().verifyCourseCodeValidation().clickResetButton()
		
		.enterCourseName(createBackupData.getCourseName()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAll()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent()
		.verifyProperSignOffStatus(createBackupData.getSignOffStatusAll()).clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAwaiting()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent()
		.verifyProperSignOffStatus(createBackupData.getSignOffStatusAwaiting()).clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusSigned()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent()
		.verifyProperSignOffStatus(createBackupData.getSignOffStatusSigned()).clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatus()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusUngraded()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent()
		.verifyNoGradedAssignmentIspresent().clickResetButton()
		
		.expectedCompletionDateInput().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.enterOriginalGraderName(createBackupData.getOriginalGraderName()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectCourseStartDate().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		;
		
		return this;	
	}
	
}
