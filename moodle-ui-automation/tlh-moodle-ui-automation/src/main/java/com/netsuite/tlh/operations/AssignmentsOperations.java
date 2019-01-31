package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.AssignmentsPage;
import com.netsuite.tlh.pages.CoursePage;

public class AssignmentsOperations extends BaseOperations {
	
	public AssignmentsOperations clickAllAsignmentsLink() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLink().completeAssignment().refreshPage();
		return this;	
	}
	
}
