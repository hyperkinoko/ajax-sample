package net.kinokolabo.reservation.model;

import javax.validation.constraints.NotBlank;

public class MemberForm {
//	@NotBlank
	private int id = 0;
	private String name = "";
	private String nameKana = "";
	private String zip = "";
	private int pref = 0;
	private String addr = "";
	private String tel1 = "";
	private String tel2 = "";
	private String mail = "";
//	private String passwd = "";
//	private String mailComfirm = "";

	public int getId() {
		return id;
	}

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

	public String getAddr() {
		return addr;
	}

	public String getTel1() {
		return tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public String getMail() {
		return mail;
	}

//	public String getPasswd() {
//		return passwd;
//	}


	//	public String getMailComfirm() {
//		return mailComfirm;
//	}
}
