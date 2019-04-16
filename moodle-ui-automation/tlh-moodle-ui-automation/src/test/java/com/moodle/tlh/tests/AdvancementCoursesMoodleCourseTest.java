package com.moodle.tlh.tests;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class AdvancementCoursesMoodleCourseTest extends BaseTest{
	
	@Test(priority=1,description = "MFD-221 ::MFD-222 ::Create a backup and Restore for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CreateABackupAndRestoreTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("TCS 1");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getRestoreCoursePage();
		Navigator.doRestore(createBackupData);	
	}
	
	@Test(priority=2,description = "MFD-223 ::MFD-264 ::Enrolling the Users", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void EnrollingTheUsers(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("TCS 2");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().enrollStudent(createBackupData,createBackupData.getUserName1())
		//.enrollStudent(createBackupData,createBackupData.getUserName4())(will enroll later)
		.enrollFacilitator(createBackupData,createBackupData.getUserName2())
		.enrollFacilitator(createBackupData,createBackupData.getUserName5())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName3())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName6()).clickOnRespectiveCourse(createBackupData);;
		
	}
	
	@Test(priority=3,description = "MFD-266 ::Activity completion settings for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void ActivityCompletionSettingsforCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("TCS 3");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		Navigator.GetCoursePageOperations().clickTurnEditingOn().
		doActivityCompletion(createBackupData.getModule2(),createBackupData)
		.doActivityCompletion(createBackupData.getModule3(),createBackupData)
		.doActivityCompletion(createBackupData.getFinalProjectSubmission(),createBackupData)
		.doParticipationAcknowledgement(createBackupData.getParticipationAcknowledgement(),createBackupData);
		rightNavOperations.clickCourseCompletion();
		Navigator.GetCoursePageOperations().doCourseCompletion(createBackupData).clickTurnEditingOff();
		
	}
	
	
	@Test(priority=4,description = "MFD-224 ::Login as student and Complete the assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void LoginAsStudentAndCompleteAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("TCS 4");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1());
		rightNavOperations.getAssignmentsPage();
		Navigator.GetAssignmentsOperations().completeAssingments();
		rightNavOperations.getCoursePage(createBackupData);
		//Navigator.GetCoursePageOperations().completeParticipationAcknowledgement(createBackupData);
		menuBarOperations.doLogOut();	
		
	}
	
	@Test(priority=5,description = "MFD-225 ::MFD-245::MFD-267::Facilitation Dashboard :Grading,Verify Rubic View, Grading Filters", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void FacilitationDashboardGradingTheAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("TCS 5");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		loginOperations.doSecondLogin(userName, passWord);
		rightNavOperations.getFacilitationManagerDashboard();
		Navigator.FacilitationManagerDashboardOperations().gradeAssigment(createBackupData);	
		
	}
	
	@Test(priority=6,description = "MFD-268 :: CourseCheckpointsAlongWithFilters", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CourseCheckpointsAlongWithFilters(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("TCS 6");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1());
		Navigator.GetCoursePageOperations().verifyCheckPoints();
		menuBarOperations.doLogOut();
		loginOperations.doSecondLogin(userName, passWord);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyResubmittedAssignment().gradeAssigment2(createBackupData);
		menuBarOperations.doLogOut();
		loginOperations.doSecondLogin(userName, passWord);
		
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().getStudentName(createBackupData);
		rightNavOperations.getFacilitationManagerDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyOriginalGraderFilter(createBackupData)
		.verifyCourseCodeFilter(createBackupData)
		;	
	}
	
	@Test(priority=7,description = "MFD-246 ::MFD-244::MFD-260::Verify dashboard views and functionality for different roles, Filter Criterias", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void VerifyDashboardViewsFunctionalityForDifferentRoles(LinkedHashMap<String, ?> testData) throws Throwable {
			System.out.println("TCS 7");
			CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			
			//Login as Facilitator
			rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2());
			rightNavOperations.getFacilitationDashboard();
			//add course code tomorrow
			Navigator.FacilitationDashboardOperations().verifyFilters(createBackupData);
			menuBarOperations.doLogOut();
			loginOperations.doSecondLogin(userName, passWord);
			
			//Login as Facilitation Manager
			rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole3(),createBackupData.getUserName6());
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyDateGradedFilter(createBackupData).verifyFilters(createBackupData);
			menuBarOperations.doLogOut();
			loginOperations.doSecondLogin(userName, passWord);
		}	
		
	@Test(priority=8,description = "MFD-269 ::Module 5: Student/FacilitatorAndFacilitationManagerFunctionality", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void  StudentFacilitatorAndFacilitationManagerFunctionality(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("TCS 8");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().enrollStudent(createBackupData,createBackupData.getUserName4()).
		loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName4());
		rightNavOperations.getAssignmentsPage();
		Navigator.GetAssignmentsOperations().completeAssingmentModule2().completeAssingmentModule3();	
		menuBarOperations.doLogOut();
		loginOperations.doSecondLogin(userName, passWord);
		
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName5());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().gradeAssigment3(createBackupData);
		menuBarOperations.doLogOut();
		loginOperations.doSecondLogin(userName, passWord);
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().UnenrollUser(createBackupData.getUserName5())
		.loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyAssignmentIsGraded(createBackupData);
		menuBarOperations.doLogOut();
		loginOperations.doSecondLogin(userName, passWord);
		rightNavOperations.getFacilitationManagerDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyDateGradedFilter(createBackupData).verifyGrader(createBackupData);
			
	}
		
		@Test(priority=9,description = "MFD-226 :: MFD-270::MFD-259:: Sign Off the assignment, Verify the Sign Off Button,sign-off button and process", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void FacilitationDashboardSignOffTheAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
			System.out.println("TCS 9");
			CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			
			Navigator.FacilitationManagerDashboardOperations().verifySignOffFunctionality();
			rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1());
			rightNavOperations.getQuizzesPage();
			//to write from here
			Navigator.GetCoursePageOperations().completeParticipationAcknowledgement2();
			menuBarOperations.doLogOut();
			loginOperations.doSecondLogin(userName, passWord);
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations().signOff(createBackupData);		
		}
		
	
	@Test(priority=10,description = "MFD-227 :: Deleting the respective course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void DeletingTheRespectiveCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("TCS 10");
		rightNavOperations.getCoursesPage();
		Navigator.GetCoursePageOperations().deleteRespectiveCourse();
		
	}

}
