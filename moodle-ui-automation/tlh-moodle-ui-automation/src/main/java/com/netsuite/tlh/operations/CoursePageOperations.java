package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.CoursePage;

public class CoursePageOperations extends BaseOperations {
	
	public CoursePageOperations deleteRespectiveCourse() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickManageCourseButton().clickDeleteCourseButton().clickDeleteButton()
		.clickContinueButton();
		return this;	
	}
	
}
