package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Book;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.Orders;
import cn.itcast.domain.User;

public interface OrderDao {

	void addOrder(Orders orders );
	
	//�����û�id���Ҷ���
	List<Orders> findOrders(String userid);
	
	//���ݶ���id���Ҷ�����
	List<OrderItem> findOrderItem(String orderid);
	
	//����״̬���Ҷ���
	List<Orders> findByStatus(int status);
	
	//�޸Ķ���
	void updateOrders(Orders orders);
	
	//���ݶ�����id������
	List<Book> findBookByOrderItemId(String orderitemid);
	
	Orders findOrder(String orderid);
	
	User findUserByOrderId(String orderid);
	
	Orders findOrderByOrderItemId(String orderitemid);
}
