package com.inaodong.milestone.service;

import java.util.List;

import com.inaodong.milestone.entity.Content;
import com.inaodong.milestone.entity.Toptic;

public interface TopticService {
	int insertToptic(Toptic toptic,Content content);

	List<Toptic> queryPageList(int currentPage, int pageSize);
}
