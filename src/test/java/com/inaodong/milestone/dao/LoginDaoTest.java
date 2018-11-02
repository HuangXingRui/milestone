package com.inaodong.milestone.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.inaodong.milestone.BaseTest;
import com.inaodong.milestone.dao.UserDao;
import com.inaodong.milestone.entity.User;

public class LoginDaoTest extends BaseTest {
	@Autowired
	private UserDao loginDao;

	@Test
	public void testQueryUser() {
		User user = loginDao.queryUser();
		assertNotNull(user);
	}
}
