package com.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 3);
		String date = DateUtils.getFormattedDate(cal.getTime(), "MM-dd-yyyy");
		System.out.println(date);
	}
}
