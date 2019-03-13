package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.BackUpPage;
import com.netsuite.tlh.pages.ParticipantsPage;
import com.netsuite.tlh.pages.RightNavBar;
import com.netsuite.tlh.testdata.CreateBackupData;

public class ParticipantsPageOperations extends BaseOperations {

	public ParticipantsPageOperations enrollStudent(CreateBackupData createBackupData, String Username) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(Username)
		.selectRoles(createBackupData.getRole1()).clickOnEnrolUsersSaveButton();
		return this;
		
	}
	
	public ParticipantsPageOperations enrollFacilitator(CreateBackupData createBackupData, String Username) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(Username)
		.selectRoles(createBackupData.getRole2()).clickOnEnrolUsersSaveButton();
		return this;
		
	}
	
	public ParticipantsPageOperations enrollFacilitationManager(CreateBackupData createBackupData, String Username) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(Username)
		.selectRoles(createBackupData.getRole3()).clickOnEnrolUsersSaveButton();
		return this;
		
	}
	
	public ParticipantsPageOperations loginAsRespectiveUser(String Role, String Username) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnRespectiveUser(Role,Username)
		.clickOnLoginAs().clickContinue();
		return this;
		
	}
	
	public ParticipantsPageOperations clickOnRespectiveCourse(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnRespectiveCourse(createBackupData.getCourseName());
		return this;
		
	}
	
	
}