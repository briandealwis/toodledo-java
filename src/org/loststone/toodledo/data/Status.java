package org.loststone.toodledo.data;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Status {

    NONE(0),
    NEXT_ACTION(1),
    ACTIVE(2),
    PLANNING(3),
    DELEGATED(4),
    WAITING(5),
    HOLD(6),
    POSTPONED(7),
    SOMEDAY(8),
    CANCELED(9),
    REFERENCE(10);
    
    private final int number; 
    Status(int number) {
    	this.number = number;
    }
    
    public int getStatusAsInteger() {return this.number;}
    
    private static final Map<Integer,Status> lookup =
    	new HashMap<Integer, Status>(11);
    
    static {
    	for(Status s : EnumSet.allOf(Status.class)) {
    		lookup.put(s.getStatusAsInteger(), s);
    	}
    }
    
    public static Status get(int number) {
    	return lookup.get(number);
    }
}
