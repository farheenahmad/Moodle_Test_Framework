package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.BackUpPage;
import com.netsuite.tlh.pages.MenuBarPage;

public class MenuBarOperations extends BaseOperations {

	public MenuBarOperations doLogOut() throws DriverNotInitializedException, Throwable {
		
		NetsuiteTLHPageFactory.getPage(MenuBarPage.class).clickmenuBarDropDown().clicklogOut();
		
		return OperationFactory.getOperation(MenuBarOperations.class);
			
	}

	

	

}