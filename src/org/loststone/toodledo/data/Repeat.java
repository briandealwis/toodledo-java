package org.loststone.toodledo.data;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Repeat {
	NO_REPEAT(0),
	WEEKLY(1),
	MONTHLY(2),
	YEARLY(3),
	DAILY(4),
	BIWEEKLY(5),
	BIMONTHLY(6),
	SEMIANNUALLY(7),
	QUARTERLY(8),
	WITH_PARENT(9);
	
	private final int number;
	private static final Map<Integer,Repeat> lookup =
		new HashMap<Integer, Repeat>(10);
	
	static {
		for(Repeat r : EnumSet.allOf(Repeat.class)) {
			lookup.put(r.getRepeatAsInteger(), r);
		}
	}

	Repeat(int number) {
		this.number = number;
	}

	public int getRepeatAsInteger() {return this.number;}

	public static Repeat get(int number) {
		return lookup.get(number);
	}
}
