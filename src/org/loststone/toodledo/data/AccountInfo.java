package org.loststone.toodledo.data;

import org.loststone.toodledo.util.TdDateTime;

public class AccountInfo {
	protected String userId;
	protected String alias;
	protected boolean pro;
	protected int dateFormat;
	protected int timezone;
	protected int hideMonths;
	protected int hotlistPriority;
	protected int hotlistDueDate;
	protected TdDateTime lastAddEdit;
	protected TdDateTime lastDelete;
	protected TdDateTime lastFolderEdit;
	protected TdDateTime lastContextEdit;
	protected TdDateTime lastGoalEdit;
	protected TdDateTime lastNotebookEdit;
	
	/**
	 * @return the Toodledo user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the Toodledo user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the user's configured alias for the account
	 */
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	/** 
	 * If true, then the user is a Pro member. 
	 * You need to know this if you want to use subtasks. 
	 */
	public boolean isPro() {
		return pro;
	}

	public void setPro(boolean pro) {
		this.pro = pro;
	}

	/**
	 * The user's preferred format for representing dates. 
	 * (0=M D, Y, 1=M/D/Y, 2=D/M/Y, 3=Y-M-D)
	 * @return the user's preferred format for representing dates.
	 */
	public int getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(int dateFormat) {
		this.dateFormat = dateFormat;
	}

	/**
	 * The number of half hours that the user's timezone is offset from 
	 * the server's timezone. A value of -4 means that the user's timezone is 
	 * 2 hours earlier than the server's timezone.
	 * @return number of half-hours from the server's timezone
	 */
	public int getTimezone() {
		return timezone;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	/**
	 * @return the number of months in the future after which tasks should be hidden
	 */
	public int getHideMonths() {
		return hideMonths;
	}

	public void setHideMonths(int hideMonths) {
		this.hideMonths = hideMonths;
	}

	/**
	 * @return priority value above which tasks should appear on the hotlist
	 */
	public int getHotlistPriority() {
		return hotlistPriority;
	}

	public void setHotlistPriority(int hotlistPriority) {
		this.hotlistPriority = hotlistPriority;
	}

	/**
	 * @return due date lead-time by which tasks should will appear on the hotlist
	 */
	public int getHotlistDueDate() {
		return hotlistDueDate;
	}

	public void setHotlistDueDate(int hotlistDueDate) {
		this.hotlistDueDate = hotlistDueDate;
	}

	/** 
	 * Timestamp that indicates the last time that any task was added or edited 
	 * on this account. You can quickly check this field to determine if you need 
	 * to download updates.
	 * @return timestamp of when any task was last added or edited on this account
	 */
	public TdDateTime getLastAddEdit() {
		return lastAddEdit;
	}

	/**
	 * @param lastAddEdit timestamp of when a task was last added or edited on this account
	 */
	public void setLastAddEdit(TdDateTime lastAddEdit) {
		this.lastAddEdit = lastAddEdit;
	}

	/**
	 *  timestamp that indicates the last time that any task was deleted from 
	 *  this account. You can quickly check this field to determine if you need to 
	 *  identify and remove tasks from your application.
	 * @return timestamp of when a task was last deleted on this account
	 */
	public TdDateTime getLastDelete() {
		return lastDelete;
	}

	/**
	 * @param lastDelete timestamp of when a task was last deleted on this account
	 */
	public void setLastDelete(TdDateTime lastDelete) {
		this.lastDelete = lastDelete;
	}

	/**
	 * Timestamp that indicates the last time that a folder was added, edited 
	 * or deleted. You can quickly check this field to determine if you need to 
	 * call getFolders to refresh your cached folder list.
	 * @return timestamp of when a folder was last deleted on this account
	 */
	public TdDateTime getLastFolderEdit() {
		return lastFolderEdit;
	}

	/**
	 * @param lastFolderEdit timestamp of when a folder was last deleted on this account
	 */
	public void setLastFolderEdit(TdDateTime lastFolderEdit) {
		this.lastFolderEdit = lastFolderEdit;
	}

	/**
	 * Timestamp that indicates the last time that a context was added, edited 
	 * or deleted. You can quickly check this field to determine if you need to 
	 * call getContexts to refresh your cached folder list.
	 * @return timestamp of when a context was last added, edited, or deleted on this account
	 */
	public TdDateTime getLastContextEdit() {
		return lastContextEdit;
	}

	public void setLastContextEdit(TdDateTime lastContextEdit) {
		this.lastContextEdit = lastContextEdit;
	}

	/**
	 * Timestamp that indicates the last time that a goal was added, edited 
	 * or deleted. You can quickly check this field to determine if you need to 
	 * call getGoals to refresh your cached folder list.
	 * @return timestamp of when a goal was last added, edited, or deleted on this account
	 */
	public TdDateTime getLastGoalEdit() {
		return lastGoalEdit;
	}

	public void setLastGoalEdit(TdDateTime lastGoalEdit) {
		this.lastGoalEdit = lastGoalEdit;
	}

	public TdDateTime getLastNotebookEdit() {
		return lastNotebookEdit;
	}

	public void setLastNotebookEdit(TdDateTime lastNotebookEdit) {
		this.lastNotebookEdit = lastNotebookEdit;
	}
}
