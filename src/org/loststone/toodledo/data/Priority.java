package org.loststone.toodledo.data;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Priority {
	NEGATIVE(-1),
	LOW(0),
	MEDIUM(1),
	HIGH(2),
	TOP(3);

	private final int number;  

	private static final Map<Integer,Priority> lookup =
		new HashMap<Integer, Priority>(5);
	
	static {
		for(Priority p : EnumSet.allOf(Priority.class)) {
			lookup.put(p.getPriorityAsInt(), p);
		}
	}

	Priority(int number) {
		this.number = number;
	}

	public int getPriorityAsInt()   { return number; }

	public static Priority get(int number) {
		return lookup.get(number);
	}
}
