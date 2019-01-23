package com.moodle.tlh.tests;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.framework.base.Browser;
import com.framework.base.BrowserFactory;
import com.framework.dataprovider.BaseDataProvider;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.exceptions.NoDataAvailableInFile;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.operations.HomeOperations;
import com.netsuite.tlh.operations.LoginOperations;
import com.netsuite.tlh.operations.MenuBarOperations;
import com.netsuite.tlh.operations.RightNavOperations;
import com.netsuite.tlh.pages.RightNavBar;

public class BaseTest {
	private static final String LOGINDETAILS_FILENAME = "src/test/resources/testdata/login-data.json";
	protected HomeOperations homeOperations;
	protected MenuBarOperations menuBarOperations;
	protected LoginOperations loginOperations;
	protected RightNavOperations rightNavOperations;
	private LinkedHashMap<String, ?> loginDataMap;
	protected String userName, passWord;

	@BeforeSuite
	public void init() throws IOException, NoDataAvailableInFile {
		loginDataMap = BaseDataProvider.getDataAsMap(LOGINDETAILS_FILENAME);
		userName = (String) loginDataMap.get("userName");
		passWord = (String) loginDataMap.get("passWord");
	}

	@BeforeClass
	public void login() throws InstantiationException, IllegalAccessException, DriverNotInitializedException, Throwable {
		BrowserFactory.initializeBrowser(Enum.valueOf(Browser.class, SystemConfigurations.getBrowserType()),
				SystemConfigurations.getApplicationUrl());
		menuBarOperations = OperationFactory.getOperation(MenuBarOperations.class);
		homeOperations = OperationFactory.getOperation(HomeOperations.class);
		loginOperations = OperationFactory.getOperation(LoginOperations.class);
		rightNavOperations = OperationFactory.getOperation(RightNavOperations.class);
		loginOperations.doLogin(userName, passWord).verifyUserLoggedInSuccessfully();
		
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitDriver();
	}

}