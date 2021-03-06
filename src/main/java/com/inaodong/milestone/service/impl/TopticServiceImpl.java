package com.inaodong.milestone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inaodong.milestone.dao.TopticDao;
import com.inaodong.milestone.dto.PageInfo;
import com.inaodong.milestone.entity.Content;
import com.inaodong.milestone.entity.Toptic;
import com.inaodong.milestone.service.TopticService;

@Service
public class TopticServiceImpl  implements TopticService{

	@Autowired
	private TopticDao topticDao;
	
	@Override
	@Transactional
	public int insertToptic(Toptic toptic, Content content) {
		int result = 0;
		int keyId = topticDao.insertToptic(toptic);
		content.setTopticId(keyId);
		result  = topticDao.insertContent(content);
		return result;
	}

	@Override
	public List<PageInfo> queryPageList(int currentPage, int pageSize) {
		List<PageInfo> topticList = topticDao.queryPageInfoList(currentPage, pageSize);
		return topticList;
	}

}
