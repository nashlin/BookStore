package cn.itcast.service;

import java.util.List;

import cn.itcast.dao.BookDao;
import cn.itcast.dao.CategoryDao;
import cn.itcast.domain.Book;
import cn.itcast.domain.Page;
import cn.itcast.utils.DaoFactory;

public class BookServiceImpl implements BookService {

	private BookDao bookDao=DaoFactory.getInstance().createDao("cn.itcast.dao.BookDaoImpl", BookDao.class);
	
	public void add(Book b){
		bookDao.add(b);
	}
	public Page getPageRecord(String currentPage) {
		int totalRecord=bookDao.getAllRecord();
		Page page=null;
		if (currentPage==null||currentPage.equals("")) {
			page=new Page(1,totalRecord);
		} else {
			page=new Page(Integer.parseInt(currentPage),totalRecord);
		}
		int startIndex=page.getStartIndex();
		int num=page.getPageSize();
		
		
		List<Book> list=bookDao.getPageRecord(startIndex, num);
		
		page.setList(list);
		return page;
	}
	public void delete(String id) {
		bookDao.delete(id);
	}
	public void update(Book book) {
		
		bookDao.update(book);
		
	}
	public Book find(String id) {
		
		return bookDao.find(id);
	}
	public Page getCategoryPageRecord(String currentPage, String categoryid) {
		
//		int totalRecord=bookDao.getAllRecord();
		int totalRecord=bookDao.getCategoryRecord(categoryid);
		Page page=null;
		if (currentPage==null||currentPage.equals("")) {
			page=new Page(1,totalRecord);
		} else {
			page=new Page(Integer.parseInt(currentPage),totalRecord);
		}
		int startIndex=page.getStartIndex();
		int num=page.getPageSize();
		
		
		List<Book> list=bookDao.getCategoryPageRecord(startIndex, num, categoryid);
		
		page.setList(list);
		return page;
	}
}
