package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.pages.BackUpPage;
import com.netsuite.tlh.pages.ParticipantsPage;
import com.netsuite.tlh.pages.RightNavBar;
import com.netsuite.tlh.testdata.CreateBackupData;

public class ParticipantsPageOperations extends BaseOperations {

	public ParticipantsPageOperations enrollStudent(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(createBackupData.getUserName1())
		.selectRoles(createBackupData.getRole1()).clickOnEnrolUsersSaveButton();
		return this;
		
	}
	
	public ParticipantsPageOperations enrollFacilitator(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(createBackupData.getUserName2())
		.selectRoles(createBackupData.getRole2()).clickOnEnrolUsersSaveButton();
		return this;
		
	}
	
	public ParticipantsPageOperations enrollFacilitationManager(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(createBackupData.getUserName3())
		.selectRoles(createBackupData.getRole3()).clickOnEnrolUsersSaveButton();
		return this;
		
	}
	
	
	
	
}