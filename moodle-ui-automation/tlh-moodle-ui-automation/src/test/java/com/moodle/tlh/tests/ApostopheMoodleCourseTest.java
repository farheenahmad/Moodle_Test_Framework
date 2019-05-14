package com.moodle.tlh.tests;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class ApostopheMoodleCourseTest extends BaseTest{
	
	@Test(priority=1,description = "Sample-1 ::Create a backup and Restore for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CreateABackupAndRestoreTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("TCS 1");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getRestoreCoursePage();
		Navigator.doRestore(createBackupData);	
	}
	
	@Test(priority=2,description = "Sample-2::Enrolling the Users", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void EnrollingTheUsers(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("TCS 2");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().enrollStudent(createBackupData,createBackupData.getUserName1())
		.enrollStudent(createBackupData,createBackupData.getUserName4())
		.enrollFacilitator(createBackupData,createBackupData.getUserName2())
		.enrollFacilitator(createBackupData,createBackupData.getUserName5())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName3())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName6())
		.enrollFacilitationManager(createBackupData,createBackupData.getPerformanceUserName())
		.clickOnRespectiveCourse(createBackupData);
		
	}
	
	@Test(priority=3,description = "MFD-316 ::VerifyAssignmentCountsOnDashboard", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void VerifyAssignmentCountsOnDashboard(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("TCS 3");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole3(),"2");
		rightNavOperations.getFacilitationManagerDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyDashboardaAssignmentsCount(createBackupData);
		menuBarOperations.doLogOut();	
		loginOperations.doSecondLogin(userName, passWord);
		rightNavOperations.getApostopheCoursesPage();
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().UnenrollUser(createBackupData.getPerformanceUserName());
		
		
	}
	
	@Test(priority=4,description = "Sample-3 ::Complete the assignment, Change Course Name", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void LoginAsStudentAndCompleteAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("TCS 4");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole1(),"1");
		rightNavOperations.getAssignmentsPage();
		Navigator.GetAssignmentsOperations().completeAssingments();
		
		menuBarOperations.doLogOut();	
		loginOperations.doSecondLogin(userName, passWord);
		
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole1(),"2");

		
		rightNavOperations.getAssignmentsPage();
		Navigator.GetAssignmentsOperations().completeAssingments();
		menuBarOperations.doLogOut();	
		loginOperations.doSecondLogin(userName, passWord);
		Navigator.GetCoursePageOperations().clickTurnEditingOn().changeAssignmentName(createBackupData.getModule2(),createBackupData.getModule2Newname())
		.changeAssignmentName(createBackupData.getModule3(),createBackupData.getModule3NewName());
		Navigator.GetCoursePageOperations().clickTurnEditingOff();
			
	}
	
	@Test(priority=5,description = "MFD-290 ::MFD-288::Apostrophe in Facilitation Dashboard filter criteria, verify deleting submitted assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void VerifyDashboardViewsFunctionalityForDifferentRoles(LinkedHashMap<String, ?> testData) throws Throwable {
			System.out.println("TCS 5");
			CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			rightNavOperations.getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole2(),"1");
			rightNavOperations.getFacilitationDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyApostopheFilters(createBackupData);
			
			menuBarOperations.doLogOut();	
			loginOperations.doSecondLogin(userName, passWord);
			rightNavOperations.getApostopheCoursesPage();
			Navigator.GetCoursePageOperations().changeCourseName( createBackupData);
			rightNavOperations.getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole2(),"1");
			rightNavOperations.getFacilitationDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyApostopheFilters2(createBackupData);
			
			menuBarOperations.doLogOut();	
			loginOperations.doSecondLogin(userName, passWord);
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyDeleteSubmissionButton(createBackupData);
			
		}	
	
	

}
