package com.inaodong.milestone.entity;

import java.util.Date;
/**
 * 主题表
 * @author SEELE
 *
 */
public class Toptic {

	// 主题id
	private Integer topticId;
	// 标题
	private String title;
	// 发帖用户id
	private Integer userId;
	// 版块
	private Integer district;
	// 创建时间
	private Date createTime;
	// 最后回复时间
	private Date replayTime;
	// 状态
	private Integer status;

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDistrict() {
		return district;
	}

	public void setDistrict(Integer district) {
		this.district = district;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getReplayTime() {
		return replayTime;
	}

	public void setReplayTime(Date replayTime) {
		this.replayTime = replayTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
