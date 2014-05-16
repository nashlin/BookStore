package cn.itcast.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.domain.Category;
import cn.itcast.utils.JdbcUtils;

public class CategoryDaoImpl implements CategoryDao {

	private static DataSource ds=JdbcUtils.getDataSource();
	public void addCategory(Category c) {

		QueryRunner qr=new QueryRunner(ds);
		String sql="insert into category (id,name,description)values(?,?,?)";
		Object[] params={c.getId(),c.getName(),c.getDescription()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void deleteCategory(String id) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="delete from category where id=?";
		Object[] params={id};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Category find(String id) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="select * from category where id=?";
		Object[] params={id};
		try {
			Category c=(Category) qr.query(sql, new BeanHandler(Category.class), params);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Category> getAll() {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="select * from category";
		Object[] params={};
		try {
			List<Category> list=(List<Category>) qr.query(sql, new BeanListHandler(Category.class), params);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void updateCategory(Category c) {

		QueryRunner qr=new QueryRunner(ds);
		String sql="update category set name=?,description=? where id=?";
		Object[] params={c.getName(),c.getDescription(),c.getId()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
