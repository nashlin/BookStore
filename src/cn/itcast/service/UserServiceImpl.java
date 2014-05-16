package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.DaoFactory;
import cn.itcast.utils.IDUtils;

public class UserServiceImpl implements UserService {

	private UserDao userDao=DaoFactory.getInstance().createDao("cn.itcast.dao.UserDaoImpl", UserDao.class);
	public void addUser(User user) {
		user.setId(IDUtils.generateID());
		userDao.addUser(user);
	}

	public User findUser(String password, String username) {
		
		return userDao.findUser(password, username);
	}

	public User findUserById(String id) {
		
		return userDao.fingUserById(id);
	}

}
