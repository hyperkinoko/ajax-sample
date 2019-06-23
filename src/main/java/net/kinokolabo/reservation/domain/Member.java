package net.kinokolabo.reservation.domain;

import java.sql.Date;

public class Member {
    private int id = 0;
//    private String lineId;
    private String name = "";
    private String nameKana = "";
    private String zip = "";
    private String addr = "";
    private int pref = 0;
    private String tel1 = "";
    private String tel2 = "";
    private String mail = "";
//    private String passwd = "";


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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getPref() {
        return pref;
    }

    public void setPref(int pref) {
        this.pref = pref;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel) {
        this.tel1 = tel;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel) {
        this.tel2 = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

//    public String getPasswd() {
//        return passwd;
//    }
//
//    public void setPasswd(String passwd) {
//        this.passwd = passwd;
//    }
}
