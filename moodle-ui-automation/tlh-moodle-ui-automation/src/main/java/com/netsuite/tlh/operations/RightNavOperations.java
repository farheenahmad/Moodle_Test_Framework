package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.RightNavBar;

public class RightNavOperations extends BaseOperations {

	public RightNavOperations getFitnessPovCoursePage() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFitnessPovCourse().verifyUserIsOnOnFitnessPovCoursePage();
		return this;
		
	}
	
	public RightNavOperations getBackUpPage() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFitnessPovCourse().verifyUserIsOnOnFitnessPovCoursePage();
		return this;
		
	}
}