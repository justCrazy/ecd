package com.ecd.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeGet {

	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = dateFormat.format(date).toString();
		return time;
	}
}
