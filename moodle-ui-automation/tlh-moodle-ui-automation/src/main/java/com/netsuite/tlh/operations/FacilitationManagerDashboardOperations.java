package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.FacilitationManagerDashboardPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class FacilitationManagerDashboardOperations extends BaseOperations {
	
	public FacilitationManagerDashboardOperations gradeAssigment() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().clickFilterButton()
		.openAssigmentsLink().gradeAssignment().openAssigmentsLink().gradeAssignment().openAssigmentsLink().gradeAssignment();
		return this;	
	}
	
	public FacilitationManagerDashboardOperations signOff(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).refreshPage().selectAssignmentStatus(createBackupData.getStatus())
		.clickFilterButton().checkIfGraded().clickOnSignOffButton();
		return this;	
	}
	
}
