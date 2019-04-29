package net.kinokolabo.reservation.domain;

import java.sql.Timestamp;

public class Open {
	private Timestamp startDatetime;
	private Timestamp endDatetime;

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
		return "[" + startDatetime.toLocalDateTime() + " : " + endDatetime.toLocalDateTime() + "]";
	}
}
