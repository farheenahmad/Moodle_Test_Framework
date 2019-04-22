package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.BackUpPage;
import com.netsuite.tlh.pages.RightNavBar;
import com.netsuite.tlh.testdata.CreateBackupData;

public class RightNavOperations extends BaseOperations {

	public RightNavOperations getFitnessPovCoursePage() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFitnessPovCourse();
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
	
	public RightNavOperations clickCourseCompletion() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickcourseCompletionLink();
		return this;	
	}
	
	
	public RightNavOperations getApostopheCoursesPage() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnApostopheCourse();
		return this;	
	}
	
	public RightNavOperations getCoursePage(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnCourse(createBackupData.getCourseShortName());
		return this;	
	}
	
	public RightNavOperations getAssignmentsPage() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnAssignments();
		return this;	
	}
	
	public RightNavOperations getQuizzesPage() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnQuizzesLink();
		return this;	
	}
	
	public RightNavOperations getFacilitationManagerDashboard() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFacilitationManagerDashboardLink();
		return this;	
	}
	
	public RightNavOperations getFacilitationDashboard() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFacilitationDashboardLink();
		return this;	
	}
	
	public RightNavOperations getRestoreCoursePage() throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnSiteAdministrationLink().clickOnSiteAdministrationCourseLink()
		.clickOnSiteAdministrationRestoreCourseLink();
		return this;	
	}
	
}