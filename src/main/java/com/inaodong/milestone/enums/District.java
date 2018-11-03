package com.inaodong.milestone.enums;

public enum District {
	DEVELOPMENT(0, "网站开发"), THOUGHT(1, "脑洞爆炸"), LIFE(2, "生活杂谈");
	private int index;

	private String district;

	private District(int index, String district) {
		this.index = index;
		this.district = district;
	}
	
	public static String getDistrict(int index) {
		for(District district : District.values()) {
			if(district.getIndex() == index) {
				return district.district;
			}
		}
		return null;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
