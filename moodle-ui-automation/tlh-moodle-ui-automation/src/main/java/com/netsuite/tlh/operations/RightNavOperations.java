package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.BackUpPage;
import com.netsuite.tlh.pages.RightNavBar;

public class RightNavOperations extends BaseOperations {

	public RightNavOperations getFitnessPovCoursePage() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFitnessPovCourse()/*.verifyUserIsOnFitnessPovCoursePage()*/;
		return this;	
	}
	
	public RightNavOperations getBackUpPage() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnBackupLink().verifyUserIsOnBackupCoursePage();
		return this;	
	}
	
	public RightNavOperations getEnrollParticipantsPage() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnParticipants();
		return this;	
	}
	
	public RightNavOperations getCoursesPage() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnCourses();
		return this;	
	}
	
	public RightNavOperations getAssignmentsPage() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnAssignments();
		return this;	
	}
	
	public RightNavOperations getFacilitationManagerDashboard() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFacilitationManagerDashboardLink();
		return this;	
	}
	
	public RightNavOperations getRestoreCoursePage() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnSiteAdministrationLink().clickOnSiteAdministrationCourseLink()
		.clickOnSiteAdministrationRestoreCourseLink();
		return this;	
	}
	
}