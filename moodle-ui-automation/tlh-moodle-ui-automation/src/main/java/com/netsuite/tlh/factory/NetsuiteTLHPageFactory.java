package com.netsuite.tlh.factory;

import org.openqa.selenium.support.PageFactory;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.pages.INetsuiteTLHPage;

public class NetsuiteTLHPageFactory {

	public static <T extends INetsuiteTLHPage> T getPage(Class<T> pageClass) throws DriverNotInitializedException {
		return PageFactory.initElements(BrowserFactory.getDriver(), pageClass);
	}
}
