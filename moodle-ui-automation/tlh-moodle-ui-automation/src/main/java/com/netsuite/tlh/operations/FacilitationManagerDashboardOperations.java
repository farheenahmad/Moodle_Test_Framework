package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.CoursePage;
import com.netsuite.tlh.pages.FacilitationManagerDashboardPage;

public class FacilitationManagerDashboardOperations extends BaseOperations {
	
	public FacilitationManagerDashboardOperations gradeAssigment() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().clickFilterButton()
		.openAssigmentsLink().gradeAssignment();
		return this;	
	}
	
}
