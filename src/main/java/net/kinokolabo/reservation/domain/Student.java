package net.kinokolabo.reservation.domain;

import java.sql.Timestamp;

public class Student {
	private int id;
	private int guardienId = 0;
	private int memberId = 0;
	private Notice notice = Notice.MAIL;
	private Timestamp birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGuardienId() {
		return guardienId;
	}

	public void setGuardienId(int guardienId) {
		this.guardienId = guardienId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
}
