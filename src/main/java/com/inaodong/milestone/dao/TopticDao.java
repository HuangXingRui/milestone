package com.inaodong.milestone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inaodong.milestone.entity.Content;
import com.inaodong.milestone.entity.Toptic;

public interface TopticDao {

	/**
	 * 插入toptic放回id
	 * 
	 * @param toptic
	 * @return
	 */
	int insertToptic(Toptic toptic);

	/**
	 * 
	 * @param content
	 * @return
	 */
	int insertContent(Content content);

	/**
	 * 返回index页显示的帖子集合
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	List<Toptic> queryTopticList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);
}
