package org.loststone.toodledo.util;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TdTime {
	
	protected LocalTime time; 
	
	public TdTime() {
		time = new LocalTime();
	}
	
	public TdTime(int hour, int minute, int second) {
		time = new LocalTime(hour, minute, second);
	}
	
	public TdTime(String content) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("hh:mm:ss");
		DateTime dt = fmt.parseDateTime(content);
		time = dt.toLocalTime();
	}

	public String toString() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("hh:mm:ss");
		return time.toString(fmt);
	}

}
