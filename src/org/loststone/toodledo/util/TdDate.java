package org.loststone.toodledo.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TdDate implements Comparable<TdDate> {
	
	protected DateTime dt; 
	
	public TdDate() {
		dt = new DateTime();
	}
	
	public TdDate(int year, int month, int day) {
	  try {
	    dt = new DateTime(year, month, day, 0,0,0,0);
	  } catch (Exception e) { dt = null; }
	}
	
	public TdDate(String content) {
		try {
			DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY-MM-dd");
			dt = fmt.parseDateTime(content);
		} catch (Exception e) { dt = null; }
	}

	public String toString() {
		if (dt == null) return "";
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY-MM-dd");
		return dt.toString(fmt);
	}

	public int compareTo(TdDate o) {
		return dt.compareTo(o.dt);
	}

}
