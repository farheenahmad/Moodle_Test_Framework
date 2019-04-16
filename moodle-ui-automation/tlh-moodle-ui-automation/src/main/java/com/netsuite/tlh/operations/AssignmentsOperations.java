package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.AssignmentsPage;
import com.netsuite.tlh.pages.CoursePage;

public class AssignmentsOperations extends BaseOperations {
	
	public AssignmentsOperations completeAssingments() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLink()/*.completeAssignment()*/.refreshPage();
		return this;	
	}
	
	public AssignmentsOperations completeAssingmentModule2() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLinkModule2().refreshPage();
		return this;	
	}
	
	public AssignmentsOperations completeAssingmentModule3() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLinkModule3().refreshPage();
		return this;	
	}
	
}
