package cn.itcast.service;

import cn.itcast.domain.User;

public interface UserService {

	void addUser(User user);
	
	User findUser(String password ,String username);
	
	User findUserById(String id);
}
