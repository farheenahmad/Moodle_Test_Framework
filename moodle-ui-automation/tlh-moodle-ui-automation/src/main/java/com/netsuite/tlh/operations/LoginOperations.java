package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.LoginPage;

public class LoginOperations implements IOperations {

	public HomeOperations doLogin(String userName, String passWord) throws DriverNotInitializedException, Throwable {
		NetsuiteTLHPageFactory.getPage(LoginPage.class).doLogIn(userName, passWord);
		return OperationFactory.getOperation(HomeOperations.class);
	}

	
}
