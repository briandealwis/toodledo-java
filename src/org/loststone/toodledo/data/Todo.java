package org.loststone.toodledo.data;

import org.loststone.toodledo.util.TdDate;
import org.loststone.toodledo.util.TdDateTime;
import org.loststone.toodledo.util.TdTime;

/**
 * This class maps all the components of a toodledo task. For more info
 * go to http://www.toodledo.com/info/api_doc.php
 * @author lant
 *
 */
public class Todo {
	int id; 
	boolean star; 
	String title;
	String tag; 
	int folder;
	int context;
	int goal;
	Priority priority;
	int reminder;
	Repeat repeat;
	String rep_advanced; 
	Status status;
	int parent;
	TdDate added; 
	TdDate startdate; 
	TdTime starttime;
	TdDate duedate;
	TdTime duetime; 
	TdDateTime modified;
	TdDate completed;
	int length; 
	String note; 
	private boolean hasId = false;
	private boolean hasStar = false;
	private boolean hasTitle = false;
	private boolean hasAdded = false;
	private boolean hasCompleted = false;
	private boolean hasModified = false;
	private boolean hasDueDate = false;
	private boolean hasDueTime = false;
	private boolean hasStartDate = false;
	private boolean hasStartTime = false;
	private boolean hasParent = false;
	private boolean hasStatus = false;
	private boolean hasReminder = false;
	private boolean hasRepeat = false;
	private boolean hasRepAdvanced = false;
	private boolean hasPriority = false;
	private boolean hasGoal = false;
	private boolean hasContext = false;
	private boolean hasFolder = false;
	private boolean hasTag = false;
	private boolean hasLength = false; 
	private boolean hasNote = false; 
	
	public Todo() {}

	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title for the task.
	 * @param title the title to set. If the title is longer than 255 charts it will be cropped.
	 */
	public void setTitle(String title) {
		if (title.length() > 255)
			this.title = title.substring(0,255);
		else
			this.title = title;
		
		this.hasTitle = true;
	}
	
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	
	/**
	 * Set the rep_advanced.
	 */
	public String getRepAdvanced() {
		return this.rep_advanced;
	}
	
	/**
	 * Get the rep_advanced.
	 */
	public void setRepAdvanced(String repAdv) {
		this.rep_advanced = repAdv; 
		this.hasRepAdvanced = true;
	}
	
	public void setNote(String note) {
		this.note = note; 
		this.hasNote = true;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public void setLength(int length) {
		this.length = length;
		this.hasLength = true;
	}
	
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
		this.hasTag = true;
	}
	
	/**
	 * @return the folder
	 */
	public int getFolder() {
		return folder;
	}
	
	/**
	 * @param folder the folder to set
	 */
	public void setFolder(int folder) {
		this.folder = folder;
		this.hasFolder = true;
	}
	
	/**
	 * @return the context
	 */
	public int getContext() {
		return context;
	}
	
	/**
	 * @param context the context to set
	 */
	public void setContext(int context) {
		this.context = context;
		this.hasContext = true;
	}
	
	/**
	 * @return the goal
	 */
	public int getGoal() {
		return goal;
	}
	
	/**
	 * @param goal the goal to set
	 */
	public void setGoal(int goal) {
		this.goal = goal;
		this.hasGoal = true;
	}
	
	/**
	 * @return the priority
	 */
	public Priority getPriority() {
		return priority;
	}
	
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Priority priority) {
		this.priority = priority;
		this.hasPriority = true;
	}
	
	/**
	 * @return the repeat
	 */
	public Repeat getRepeat() {
		return repeat;
	}
	
	/**
	 * @param repeat the repeat to set
	 */
	public void setRepeat(Repeat repeat) {
		this.repeat = repeat;
		this.hasRepeat = true; 
	}
	
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
		this.hasStatus = true;
	}
	
	/**
	 * @return the parent
	 */
	public int getParent() {
		return parent;
	}
	
	/**
	 * @param parent the parent to set
	 */
	public void setParent(int parent) {
		this.parent = parent;
		this.hasParent = true;
	}
		
	/**
	 * @return the due date
	 */
	public TdDate getDueDate() {
		return duedate;
	}
	
	/**
	 * @return the due time
	 */
	public TdTime getDueTime() {
		return duetime;
	}
	
	/**
	 * @param date the due date to set
	 */
	public void setDueDate(TdDate date) {
		this.duedate = date;
		this.hasDueDate = true;
	}
	
	/**
	 * @param time the due time to set
	 */
	public void setDueTime(TdTime time) {
		this.duetime = time;
		this.hasDueTime = true;
	}
	
	/**
	 * @return the start date
	 */
	public TdDate getStartDate() {
		return startdate;
	}
	
	/**
	 * @return the start time
	 */
	public TdTime getStartTime() {
		return starttime;
	}
	
	/**
	 * @param date the start date to set
	 */
	public void setStartDate(TdDate date) {
		this.startdate = date;
		this.hasStartDate = true;
	}
	
	/**
	 * @param time the start time to set
	 */
	public void setStartTime(TdTime time) {
		this.starttime = time;
		this.hasStartTime = true;
	}
	
	/**
	 * @return the modified date/time
	 */
	public TdDateTime getModified() {
		return modified;
	}
	
	/**
	 * @param dt the modified to set
	 */
	public void setModified(TdDateTime dt) {
		this.modified = dt;
		this.hasModified = true;
	}
	
	/**
	 * @return the added
	 */
	public TdDate getAdded() {
		return added;
	}
	
	/**
	 * @param date the added to set
	 */
	public void setAdded(TdDate date) {
		this.added = date;
		this.hasAdded = true;
	}
	
	/**
	 * @return the completed
	 */
	public TdDate getCompleted() {
		return completed;
	}
	
	/**
	 * @param date the completed to set
	 */
	public void setCompleted(TdDate date) {
		this.completed = date;
		this.hasCompleted = true;
	}
	
	/**
	 * @return the star
	 */
	public boolean isStar() {
		return star;
	}
	
	/**
	 * @param star the star to set
	 */
	public void setStar(boolean star) {
		this.star = star;
		this.hasStar = true;
	}

	public void setReminder(int mins) {
		this.reminder = mins;
		this.hasReminder = true;
	}


	public int getReminder() {
		return this.reminder;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
		this.hasId = true;
	}
	
	/**
	 * @return the hasId
	 */
	public boolean hasId() {
		return hasId;
	}

	/**
	 * @return the hasStar
	 */
	public boolean hasStar() {
		return hasStar;
	}

	/**
	 * @return the hasStartDate
	 */
	public boolean hasStartDate() {
		return hasStartDate;
	}

	/**
	 * @return the hasStartTime
	 */
	public boolean hasStartTime() {
		return hasStartTime;
	}

	/**
	 * @return the hasDueDate
	 */
	public boolean hasDueDate() {
		return hasDueDate;
	}

	/**
	 * @return the hasDueTime
	 */
	public boolean hasDueTime() {
		return hasDueTime;
	}

	/**
	 * @return the hasAdded
	 */
	public boolean hasAdded() {
		return hasAdded;
	}

	/**
	 * @return the hasCompleted
	 */
	public boolean hasCompleted() {
		return hasCompleted;
	}

	/**
	 * @return the hasModified
	 */
	public boolean hasModified() {
		return hasModified;
	}

	/**
	 * @return the hasParent
	 */
	public boolean hasParent() {
		return hasParent;
	}

	/**
	 * @return the hasStatus
	 */
	public boolean hasStatus() {
		return hasStatus;
	}

	/**
	 * @return the hasRepeat
	 */
	public boolean hasRepeat() {
		return hasRepeat;
	}

	/**
	 * @return the hasPriorit
	 */
	public boolean hasPriority() {
		return hasPriority;
	}

	/**
	 * @return the hasGoal
	 */
	public boolean hasGoal() {
		return hasGoal;
	}

	/**
	 * @return the hasContext
	 */
	public boolean hasContext() {
		return hasContext;
	}

	/**
	 * @return the hasFolder
	 */
	public boolean hasFolder() {
		return hasFolder;
	}

	/**
	 * @return the hasTag
	 */
	public boolean hasTag() {
		return hasTag;
	}

	/**
	 * @return the hasTitle
	 */
	public boolean hasTitle() {
		return hasTitle;
	} 
	
	public boolean hasRepAdvanced() {
		return this.hasRepAdvanced;
	}
	
	public boolean hasLength() {
		return this.hasLength;
	}
	
	public boolean hasNote() {
		return this.hasNote;
	}

	public boolean hasReminder() {
		return this.hasReminder;
	}

}
