package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Book;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.Orders;
import cn.itcast.domain.User;

public interface OrderDao {

	void addOrder(Orders orders );
	
	//根据用户id查找订单
	List<Orders> findOrders(String userid);
	
	//根据订单id查找订单项
	List<OrderItem> findOrderItem(String orderid);
	
	//根据状态查找订单
	List<Orders> findByStatus(int status);
	
	//修改订单
	void updateOrders(Orders orders);
	
	//根据订单项id查找书
	List<Book> findBookByOrderItemId(String orderitemid);
	
	Orders findOrder(String orderid);
	
	User findUserByOrderId(String orderid);
	
	Orders findOrderByOrderItemId(String orderitemid);
}
