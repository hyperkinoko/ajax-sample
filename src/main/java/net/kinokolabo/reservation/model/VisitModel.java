package net.kinokolabo.reservation.model;

import net.kinokolabo.reservation.domain.JoinOrLeave;

public class VisitModel {
	private int studentId = 0;
	private String joinOrLeave = JoinOrLeave.JOIN.toString();
	private int courseId = 0;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getJoinOrLeave() {
		return joinOrLeave;
	}

	public void setJoinOrLeave(String joinOrLeave) {
		this.joinOrLeave = joinOrLeave;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
}
