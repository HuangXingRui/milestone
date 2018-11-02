package com.inaodong.milestone.dao;

import com.inaodong.milestone.entity.Content;
import com.inaodong.milestone.entity.Toptic;

public interface TopticDao {
	
	/**
	 * 插入toptic放回id
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
}
