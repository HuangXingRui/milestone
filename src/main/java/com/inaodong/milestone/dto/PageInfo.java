package com.inaodong.milestone.dto;

import com.inaodong.milestone.enums.District;

/**
 * 返回数据 用于首页呈现帖子的信息
 * 
 * @author SEELE
 *
 */
public class PageInfo {

	private Integer topticId;

	private String title;

	private String district;

	private String nickName;

	private long beforeTime;

	//头像功能暂未处理
	private String imageURL="/milestone/resources/images/touxiang.jpg";

	public Integer getTopticId() {
		return topticId;
	}

	public void setTopticId(Integer topticId) {
		this.topticId = topticId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = District.getDistrict(district);
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public long getBeforeTime() {
		return beforeTime;
	}

	public void setBeforeTime(long beforeTime) {
		this.beforeTime = beforeTime;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
}
