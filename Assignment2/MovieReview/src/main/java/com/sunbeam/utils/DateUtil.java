package com.sunbeam.utils;

import java.text.SimpleDateFormat;

public class DateUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static String toString(java.util.Date date) {
		return sdf.format(date);
	}
	public static java.util.Date parse(String dateStr) {
		try {
			return sdf.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static java.util.Date sqlToUtilDate(java.sql.Date sDate) {
		return new java.util.Date(sDate.getTime());
	}
	public static java.sql.Date utilToSqlDate(java.util.Date uDate) {
		return new java.sql.Date(uDate.getTime());
	}
}

