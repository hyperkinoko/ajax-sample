package net.kinokolabo.reservation.model;


public class StudentForm {
	private int gardianId = 0; //hidden
	private int memberId = 0;
	private int id = 0; //hidden
	private String name = "";
	private String nameKana = "";
	private String zip = "";
	private int pref = 0;
	private String addr = "";
	private String tel1 = "";
	private String tel2 = "";
	private String mail = "";
	private boolean notice = true;
	private int bYear = 0;
	private int bMonth = 0;
	private int bDay = 0;

	public int getGardianId() {
		return gardianId;
	}

	public void setGardianId(int gardianId) {
		this.gardianId = gardianId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameKana() {
		return nameKana;
	}

	public void setNameKana(String nameKana) {
		this.nameKana = nameKana;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getPref() {
		return pref;
	}

	public void setPref(int pref) {
		this.pref = pref;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isNotice() {
		return notice;
	}

	public void setNotice(boolean notice) {
		this.notice = notice;
	}

	public int getbYear() {
		return bYear;
	}

	public void setbYear(int bYear) {
		this.bYear = bYear;
	}

	public int getbMonth() {
		return bMonth;
	}

	public void setbMonth(int bMonth) {
		this.bMonth = bMonth;
	}

	public int getbDay() {
		return bDay;
	}

	public void setbDay(int bDay) {
		this.bDay = bDay;
	}
}
