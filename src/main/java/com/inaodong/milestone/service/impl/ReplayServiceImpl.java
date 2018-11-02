package com.inaodong.milestone.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inaodong.milestone.dao.ReplayDao;
import com.inaodong.milestone.entity.Replay;
import com.inaodong.milestone.service.ReplayService;

@Service
public class ReplayServiceImpl implements ReplayService{

	@Autowired
	private ReplayDao replayDao;
	@Override
	public int insertRepaly(Replay replay) {
		
		int result = replayDao.insertReplay(replay);
		return result;
	}

}
