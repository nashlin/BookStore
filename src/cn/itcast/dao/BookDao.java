package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Book;

public interface BookDao {

	void add(Book b);
	
	void delete(String id);
	
	void update(Book book);
	
	Book find(String id);

	//��ȡ���м�¼��������
	int getAllRecord();

	//��ȡ��ҳ��¼
	List<Book> getPageRecord(int startIndex, int num);

	//��ȡ��¼���������շ���
	int getCategoryRecord(String category_id);

	//��ȡ��ҳ��¼���շ���
	List<Book> getCategoryPageRecord(int startIndex, int num, String category_id);

}