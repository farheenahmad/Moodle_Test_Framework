package com.framework.base;

import com.framework.utils.PropertyLoader;

public interface BaseParams {
	public final static String baseUrl = PropertyLoader.loadProperty("app.url").get();
	public final static long maxTimeoutInSecs = Long.parseLong(PropertyLoader.loadProperty("max.wait.time").get());
	public final static long maxTimeoutInSecsForElement = Long.parseLong(PropertyLoader.loadProperty("max.wait.time.element").get());
	public final static long sleepInMillisecs = Long.parseLong(PropertyLoader.loadProperty("sleep.time").get());
}
