package org.loststone.toodledo.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TdDateTime extends TdDate {

	public TdDateTime() {
		super();
	}
	
	public TdDateTime(int year, int month, int day, int hour, int minute, int second) {
		this.dt = new DateTime(year, month, day, hour, minute, second, 0);
	}
	
	public TdDateTime(String content) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");
		dt = fmt.parseDateTime(content);
	}

	public String toString() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");
		return dt.toString(fmt);
	}
}
