package cn.itcast.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.domain.User;
import cn.itcast.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
	
	private DataSource ds=JdbcUtils.getDataSource();

	public void addUser(User user) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="insert into user (id,username,password,cellphone,email,address)values(?,?,?,?,?,?)";
		Object [] params={user.getId(),user.getUsername(),user.getPassword(),user.getCellphone(),user.getEmail(),user.getAddress()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User findUser(String password, String username) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="select * from user where password=? and username=?";
		Object [] params={password,username};
		try {
			return (User) qr.query(sql, new BeanHandler(User.class), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User fingUserById(String id) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="select * from user where id=?";
		Object [] params={id};
		try {
			return (User) qr.query(sql, new BeanHandler(User.class), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
