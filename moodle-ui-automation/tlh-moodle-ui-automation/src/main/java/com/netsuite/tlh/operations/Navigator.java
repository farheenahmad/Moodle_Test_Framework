package com.netsuite.tlh.operations;

import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Navigator extends BaseOperations {

	
	public static BackUpPageOperations gotoBackUpPage() throws Throwable {
		return OperationFactory.getOperation(BackUpPageOperations.class).DoTheBackup();
	}
	
	public static RestorePageOperations doRestore(CreateBackupData createBackupData) throws Throwable {
		return OperationFactory.getOperation(RestorePageOperations.class).DoTheRestore(createBackupData);
	}
	
	public static ParticipantsPageOperations GetParticipationOperationsPage() throws Throwable {
		return OperationFactory.getOperation(ParticipantsPageOperations.class);
	}
	public static CoursePageOperations GetCoursePageOperations() throws Throwable {
		return OperationFactory.getOperation(CoursePageOperations.class);
	}
	
	public static AssignmentsOperations GetAssignmentsOperations() throws Throwable {
		return OperationFactory.getOperation(AssignmentsOperations.class);
	}
	
	public static FacilitationManagerDashboardOperations FacilitationManagerDashboardOperations() throws Throwable {
		return OperationFactory.getOperation(FacilitationManagerDashboardOperations.class);
	}
	
}
