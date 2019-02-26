package com.moodle.tlh.tests;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class AdvancementCoursesMoodleCourseTest extends BaseTest{
	
	@Test(priority=1,description = "MFD-221 ::MFD-222 ::Create a backup and Restore for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CreateABackupAndRestoreTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {

		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		//rightNavOperations.getFitnessPovCoursePage().getBackUpPage();//Navigator.gotoBackUpPage();//Navigator.doRestore(createBackupData);
		rightNavOperations.getRestoreCoursePage();
		Navigator.doRestore(createBackupData);
		
	}
	
	@Test(priority=2,description = "MFD-223 ::Enrolling the Users", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void EnrollingTheUsers(LinkedHashMap<String, ?> testData) throws Throwable {

		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().enrollStudent(createBackupData)
		.enrollFacilitator(createBackupData).enrollFacilitationManager(createBackupData);
		
	}
	@Test(priority=3,description = "MFD-224 ::Login as student and Complete the assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void LoginAsStudentAndCompleteAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData);
		rightNavOperations.getAssignmentsPage();
		Navigator.GetAssignmentsOperations().completeAssingments();
		menuBarOperations.doLogOut();
		
	}
	
	@Test(priority=4,description = "MFD-225 ::MFD-226:MFD-245:Facilitation dashboard :Grading and Sign Off the assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void FacilitationDashboardGradingTheAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		loginOperations.doSecondLogin(userName, passWord);
		rightNavOperations.getFacilitationManagerDashboard();
		Navigator.FacilitationManagerDashboardOperations().gradeAssigment().signOff(createBackupData);	
		
	}
	
	@Test(priority=5,description = "MFD-244 ::new filters added to Facilitator Dashboard", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void newFiltersAddedToFacilitatorDashboard(LinkedHashMap<String, ?> testData) throws Throwable {
		
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getFacilitationManagerDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyDateGradedFilter(createBackupData);	
		
	}
	
	@Test(priority=7,description = "MFD-227 :: Deleting the respective course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void DeletingTheRespectiveCourse(LinkedHashMap<String, ?> testData) throws Throwable {
	
		rightNavOperations.getCoursesPage();
		
		Navigator.GetCoursePageOperations().deleteRespectiveCourse();
		
	}

}
