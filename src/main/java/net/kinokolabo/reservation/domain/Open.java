package net.kinokolabo.reservation.domain;

import java.sql.Timestamp;

public class Open {
	private int id = 0;
	private Timestamp startDatetime;
	private Timestamp endDatetime;

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
	public Timestamp getEndDatetime() {
		return endDatetime;
	}
	public void setEndDatetime(Timestamp endDatetime) {
		this.endDatetime = endDatetime;
	}

	public String toString() {
		return "[" + id + " : " + startDatetime.toLocalDateTime() + " : " + endDatetime.toLocalDateTime() + "]";
	}
}
