package com.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String getCurrentDate(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
	}

	public static String getFormattedDate(Date date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}

	public static Date getFormattedDate(String dateAsString, String dateFormat) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		Date convertedDate = (Date) formatter.parse(dateAsString);
		return convertedDate;
	}
}
