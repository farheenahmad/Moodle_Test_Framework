package com.moodle.tlh.tests;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.netsuite.tlh.testdata.CreateBackupData;


public class Module_1_CreateBackup_Testuite extends BaseTest{
	
	@Test(description = "MFD-221 :: Create a backup for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CreateABackupForCourse(LinkedHashMap<String, ?> testData) throws Throwable {

		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getFitnessPovCoursePage().getBackUpPage();
		
	}

}
