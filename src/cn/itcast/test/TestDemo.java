package cn.itcast.test;

import java.util.Date;

import org.junit.Test;

import cn.itcast.dao.BookDao;
import cn.itcast.dao.BookDaoImpl;
import cn.itcast.dao.OrderDao;
import cn.itcast.dao.OrderDaoImpl;
import cn.itcast.domain.Book;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.Orders;
import cn.itcast.domain.User;

public class TestDemo {

	@Test
	public void testAddOrder(){
		
		BookDao bookDao=new BookDaoImpl();
		Book book=bookDao.find("0d85d8b0-fe9d-4863-97bb-f44490b6083a");
		
		User user=new User();
		user.setAddress("³Îº£");
		user.setCellphone("333");
		user.setEmail("12345");
		user.setId("fa5a701f-b135-451c-a2a9-f8ffbf35464b");
		user.setPassword("33434");
		user.setUsername("±ò±ò");
		
		OrderItem item=new OrderItem();
		item.setBook(book);
		item.setId("234");
		item.setNum(2);
		item.setPrice(12);
		
		Orders orders=new Orders();
		orders.setId("11332");
		orders.setDate(new Date());
		orders.setStatus(1);
		orders.setUser(user);
		orders.getSet().add(item);
		orders.setTotalPrice(item.getPrice());
		
		OrderDao orderDao=new OrderDaoImpl();
		orderDao.addOrder(orders);
	}
}
