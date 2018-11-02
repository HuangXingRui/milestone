package com.inaodong.milestone.service;

import com.inaodong.milestone.entity.User;

public interface UserService {
	
	int register(User user);

	User login(String username, String password);

	int checkUserName(String userName);
	
	int checkNickName(String nickName);
	
	int checkEmail(String email);
}
