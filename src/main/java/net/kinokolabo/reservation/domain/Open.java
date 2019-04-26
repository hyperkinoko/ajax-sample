package net.kinokolabo.reservation.domain;

import java.sql.Timestamp;

public class Open {
	private int id = 0;
	private Timestamp startDatetime;
	private Timestamp endDateTime;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getStartDatetime() {
		return startDatetime;
	}
	public void setStartDatetime(Timestamp startDatetime) {
		this.startDatetime = startDatetime;
	}
	public Timestamp getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}
}
