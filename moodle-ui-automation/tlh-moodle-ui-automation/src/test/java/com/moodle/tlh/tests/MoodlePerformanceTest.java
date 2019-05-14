package com.moodle.tlh.tests;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class MoodlePerformanceTest extends BaseTest{
	
	@Test(priority=1,description = "MFD-221 ::MFD-222 ::Create a backup and Restore for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CreateABackupAndRestoreTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("1");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getRestoreCoursePage();
		Navigator.doRestore(createBackupData);	
	}
	
	@Test(priority=2,description = "MFD-223 ::MFD-264 ::Enrolling the Users", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void EnrollingTheUsers(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("2");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage()
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName3())
		.enrollFacilitationManager(createBackupData,createBackupData.getPerformanceUserName());
		
	}
	
	@Test(priority=3,description = "MFD-224 ::Login as student and Complete the assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void LoginAsStudentAndCompleteAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("3");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole3(),createBackupData.getPerformanceUserName());
		
	}
	
	@Test(priority=4,description = "MFD-258 ::MFD-299::MFD-320::MFD-321:: Dashboard performance test script, Fetch Datat button functionality and its performance", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void DashboardPerformanceTestScript(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("4");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations()
			.getLoadingDashboardPerformance()
			.getRefreshDashboardPerformance()
			.getGradedFilterDashboardPerformance(createBackupData)
			.getFetchDataDashboardPerformance()
			;	
			
		}
	
	@Test(priority=5,description = "MFD-227 :: Deleting the respective course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void DeletingTheRespectiveCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("5");
		rightNavOperations.clickCoursesLink();
		Navigator.GetCoursePageOperations().deleteRespectiveCourse();
		
	}

}
