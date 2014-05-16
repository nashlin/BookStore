package cn.itcast.service;

import cn.itcast.domain.Book;
import cn.itcast.domain.Page;

public interface BookService {

	void add(Book b);

	Page getPageRecord(String currentPage);
	
	Page getCategoryPageRecord(String currentPage,String categoryid);
	
	void delete(String id);
	
	void update(Book book);
	
	Book find(String id);
}