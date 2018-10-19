package com.huskyshare.backend.service;

import org.springframework.transaction.annotation.Transactional;
import com.huskyshare.backend.hibernate.dao.UserDao;
import com.huskyshare.backend.model.user.User;

@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void register(User user) {
		if(userDao.find(user)==-1)
			userDao.save(user);
	}
}
