package net.kinokolabo.reservation.domain;

import java.sql.Timestamp;

public class Student {
	private int id;
	private int gardienId = 0;
	private int memberId = 0;
	private boolean notice = true;
	private Timestamp birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGardienId() {
		return gardienId;
	}

	public void setGardienId(int gardienId) {
		this.gardienId = gardienId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public boolean isNotice() {
		return notice;
	}

	public void setNotice(boolean notice) {
		this.notice = notice;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
}
