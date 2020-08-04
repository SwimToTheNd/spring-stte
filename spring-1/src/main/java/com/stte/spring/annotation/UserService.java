package com.stte.spring.annotation;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

	@Resource
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void addNew(){
		System.out.println("addNew...");
		userDao.save();
	}
	
}
