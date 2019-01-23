package com.netsuite.tlh.operations;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.base.INetsuiteTLHParams;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;

import com.netsuite.tlh.pages.HomePage;

public class HomeOperations extends MenuBarOperations implements
		INetsuiteTLHParams {
	protected HomePage homePage;
	

	public HomeOperations() throws DriverNotInitializedException {
		homePage = NetsuiteTLHPageFactory.getPage(HomePage.class);
	}

	public HomeOperations verifyUserLoggedInSuccessfully() throws Throwable {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(homePage.isHomeLabelDisplayed(),
				"Home Label NOT displayed");
		softAssert.assertTrue(homePage.isHomeIconDisplayed(),
				"Home icon NOT displayed");
		softAssert.assertAll();
		return this;
	}



	
}
