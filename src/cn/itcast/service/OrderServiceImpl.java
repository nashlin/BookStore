package cn.itcast.service;

import java.util.List;

import cn.itcast.dao.OrderDao;
import cn.itcast.domain.Book;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.Orders;
import cn.itcast.domain.User;
import cn.itcast.utils.DaoFactory;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao=DaoFactory.getInstance().createDao("cn.itcast.dao.OrderDaoImpl", OrderDao.class);
	public void addOrder(Orders orders) {

		orderDao.addOrder(orders);
	}

	public List<Orders> findByStatus(int status) {
		return orderDao.findByStatus(status);
	}

	public List<OrderItem> findOrderItem(String orderid) {
		return orderDao.findOrderItem(orderid);
	}

	public List<Orders> findOrders(String userid) {
		return orderDao.findOrders(userid);
	}

	public void updateOrders(Orders orders) {

		orderDao.updateOrders(orders);
	}

	public List<Book> findBookByOrderItemId(String orderitemid) {

		return orderDao.findBookByOrderItemId(orderitemid);
	}

	public Orders findOrder(String orderid) {
		
		return orderDao.findOrder(orderid);
	}

	public User findUserByOrderId(String orderid) {
		
		return orderDao.findUserByOrderId(orderid);
	}

	public Orders findOrderByOrderItemId(String orderitemid) {

		return orderDao.findOrderByOrderItemId(orderitemid);
	}

}
