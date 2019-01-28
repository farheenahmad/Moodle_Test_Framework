package com.framework.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {
	public static String getAutoRandomString(int lengthOfName){
		return RandomStringUtils.randomAlphabetic(lengthOfName);
	}
	
	public static String getRandomNumber(int lengthOfNumber){
		return RandomStringUtils.randomNumeric(lengthOfNumber);
	}
	
	public static String getAutoAlphaNumericString(int lengthOfString){
		return RandomStringUtils.randomAlphanumeric(lengthOfString);
	}
	
	public static String getRandomString(int lengthOfName){
		return RandomStringUtils.randomAlphabetic(lengthOfName);
	}
	public static String getAlphaNumericString(int lengthOfString){
		return RandomStringUtils.randomAlphanumeric(lengthOfString);
	}
}
