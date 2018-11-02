package com.inaodong.milestone.entity;

import java.util.Date;

public class Replay {
	// 回帖id
	private Integer replayId;
	// 主题id
	private Integer topticId;
	// 回复内容
	private String content;
	// 创建时间
	private Date createTime;
	// 状态
	private Integer status;

	public Integer getReplayId() {
		return replayId;
	}

	public void setReplayId(Integer replayId) {
		this.replayId = replayId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
