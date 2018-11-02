package com.inaodong.milestone.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inaodong.milestone.dao.UserDao;
import com.inaodong.milestone.entity.User;
import com.inaodong.milestone.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public int register(User user) {

		int result = userDao.register(user);
		return result;
	}

	@Override
	public User login(String username, String password) {
		User user = userDao.login(username, password);
		if (user != null) {
			Date date = new Date();
			userDao.updateLoginTime(user.getUserId(), date);
		}
		return user;
	}

	@Override
	public int checkUserName(String userName) {
		int result = userDao.checkUserName(userName);
		return result;
	}

	@Override
	public int checkNickName(String nickName) {
		int result = userDao.checkNickName(nickName);
		return result;
	}

	@Override
	public int checkEmail(String email) {
		int result = userDao.checkEmail(email);
		return result;
	}
}
