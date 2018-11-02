package com.inaodong.milestone.dao;

import com.inaodong.milestone.entity.Replay;

public interface ReplayDao {

	/**
	 * 回复功能
	 * @param replay
	 * @return
	 */
	int insertReplay(Replay replay);
}
