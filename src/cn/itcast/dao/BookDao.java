package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Book;

public interface BookDao {

	void add(Book b);
	
	void delete(String id);
	
	void update(Book book);
	
	Book find(String id);

	//获取所有记录的总数量
	int getAllRecord();

	//获取分页记录
	List<Book> getPageRecord(int startIndex, int num);

	//获取记录总数量按照分类
	int getCategoryRecord(String category_id);

	//获取分页记录按照分类
	List<Book> getCategoryPageRecord(int startIndex, int num, String category_id);

}