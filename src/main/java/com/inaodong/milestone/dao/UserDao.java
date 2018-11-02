package com.inaodong.milestone.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.inaodong.milestone.entity.User;

public interface UserDao {

	/**
	 * 
	 * @return
	 */
	User queryUser();

	/**
	 * 注册
	 * 
	 * @param user
	 * @return
	 */
	int register(User user);

	/**
	 * 登录
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	User login(@Param("userName") String userName, @Param("password") String password);

	/**
	 * 校验用户名
	 * 
	 * @param userName
	 * @return
	 */
	int checkUserName(@Param("userName") String userName);

	/**
	 * 校验邮箱
	 * 
	 * @param email
	 * @return
	 */
	int checkEmail(@Param("email") String email);

	/**
	 * 校验昵称
	 * 
	 * @param nickName
	 * @return
	 */
	int checkNickName(@Param("nickName") String nickName);
	
	/**
	 * 更新登录时间
	 * @param userId
	 * @param date
	 * @return
	 */
	int updateLoginTime(@Param("userId")Integer userId, @Param("loginTime")Date date);
}
