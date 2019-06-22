package net.kinokolabo.reservation.model;

import javax.validation.constraints.NotBlank;

public class MemberForm {
//	@NotBlank
//	private int id = 0;
	private String name = "";
	private String nameKana = "";
	private String zip = "";
	private int pref = 0;
	private String address = "";
	private String telNo = "";
	private String mail = "";
//	private String mailComfirm = "";

//	public int getId() {
//		return id;
//	}

	public String getName() {
		return name;
	}

	public String getNameKana() {
		return nameKana;
	}

	public String getZip() {
		return zip;
	}

	public int getPref() {
		return pref;
	}

	public String getAddress() {
		return address;
	}

	public String getTelNo() {
		return telNo;
	}

	public String getMail() {
		return mail;
	}

//	public String getMailComfirm() {
//		return mailComfirm;
//	}
}
