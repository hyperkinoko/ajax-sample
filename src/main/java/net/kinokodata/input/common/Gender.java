package net.kinokodata.input.common;

public enum Gender {
	MAN("男性", "男"), WOMAN("女性", "女"), OTHER("その他", "その他");

	private final String nameJP;
	private final String nameJPShort;

	private Gender(String nameJP, String nameJPShort) {
		this.nameJP = nameJP;
		this.nameJPShort = nameJPShort;
	}

	public String getNameJP() {
		return nameJP;
	}

	public String getNameJPShort() {
		return nameJPShort;
	}

	public static Gender getByName(String name) {
		for(Gender gender : Gender.values()) {
			if(gender.name().equals(name)) {
				return gender;
			}
		}
		return null;
	}
}
