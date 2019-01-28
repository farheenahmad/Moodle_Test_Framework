package com.framework.utils;

import java.text.DecimalFormat;

public class NumberUtility {
	/*
	 * It converts given number to decimal format and in group of 3s or
	 * thousands say, 2500.589 ---> 2,500.59
	 */
	public static String getGroupedDecimalFormatNumber(Double number) {
		DecimalFormat df = new DecimalFormat("#.00");
		df.setGroupingUsed(true);
		df.setGroupingSize(3);
		String formattedNumber = df.format(number);
		return formattedNumber;
	}
}
