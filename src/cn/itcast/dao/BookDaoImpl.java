package cn.itcast.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.domain.Book;
import cn.itcast.utils.JdbcUtils;

public class BookDaoImpl implements BookDao {

	private DataSource ds=JdbcUtils.getDataSource();
	public void add(Book b){
		QueryRunner qr=new QueryRunner(ds);
		String sql="insert into book (id,name,oldname,author,price,description,image,category_id)values(?,?,?,?,?,?,?,?)";
		Object [] params={b.getId(),b.getName(),b.getOldname(),b.getAuthor(),b.getPrice(),b.getDescription(),b.getImage(),b.getCategory().getId()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//获取所有记录的总数量
	public int getAllRecord(){
		QueryRunner qr=new QueryRunner(ds);
		String sql="select count(*) from book";
		try {
			Long num=(Long) qr.query(sql,new ScalarHandler(1));
			return num.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//获取分页记录
	public List<Book> getPageRecord(int startIndex,int num){
		QueryRunner qr=new QueryRunner(ds);
		String sql="select id,name,oldname,author,price,description,image,category_id from book limit ?,?";
		Object [] params={startIndex,num};
		try {
		return (List<Book>) qr.query(sql, new BeanListHandler(Book.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//获取记录总数量按照分类
	public int getCategoryRecord(String category_id){
		QueryRunner qr=new QueryRunner(ds);
		String sql="select * from book where category_id=?";
		Object [] params={category_id};
		try {
//			Long num=(Long) qr.query(sql, new ScalarHandler(1), params);
//			return num.intValue();
			List<Book> list=(List<Book>) qr.query(sql, new BeanListHandler(Book.class), params);
			return list.size();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//获取分页记录按照分类
	public List<Book> getCategoryPageRecord(int startIndex,int num,String category_id){
		QueryRunner qr=new QueryRunner(ds);
		String sql="select id,name,oldname,author,price,description,image,category_id from book where category_id=? limit ?,?";
		Object [] params={category_id,startIndex,num};
		try {
			return (List<Book>) qr.query(sql, new BeanListHandler(Book.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void delete(String id) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="delete from book where id=?";
		Object [] params={id};
		try {
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void update(Book book) {
		QueryRunner qr=new QueryRunner(ds);
		String sql="update book set name=?,author=?,price=?,description=?,image=?,category_id=? where id=?";
		Object [] params={book.getName(),book.getAuthor(),book.getPrice(),book.getDescription(),book.getImage(),book.getCategory().getId(),book.getId()};
		try {
			qr.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public Book find(String id) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="select * from book where id=?";
		Object [] params={id};
		try {
			return (Book) qr.query(sql, new BeanHandler(Book.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
