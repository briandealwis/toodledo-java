package org.loststone.toodledo.util;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TdTime implements Comparable<TdTime> {
	
	protected LocalTime time; 
	
	public TdTime() {
		time = new LocalTime();
	}
	
	public TdTime(int hour, int minute, int second) {
		time = new LocalTime(hour, minute, second);
	}
	
	public TdTime(String content) {
		// In practice, Toodledo returns times as '11:00 am'
		// though its examples don't include the space.
		DateTimeFormatter fmt = DateTimeFormat.forPattern("hh:mmaa");
		DateTime dt = fmt.parseDateTime(content.replace(" ", ""));
		time = dt.toLocalTime();
	}

	public String toString() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("hh:mm aa");
		return time.toString(fmt);
	}

	public int compareTo(TdTime o) {
		return time.compareTo(o.time);
	}

}
