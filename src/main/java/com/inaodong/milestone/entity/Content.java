package com.inaodong.milestone.entity;

public class Content {
	// 内容id
	private Integer contentId;
	// 主题id
	private Integer topticId;
	// 内容
	private String content;

	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public Integer getTopticId() {
		return topticId;
	}

	public void setTopticId(Integer topticId) {
		this.topticId = topticId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
