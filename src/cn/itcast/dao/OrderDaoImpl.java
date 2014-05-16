package cn.itcast.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.domain.Book;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.Orders;
import cn.itcast.domain.User;
import cn.itcast.utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {

	private DataSource ds=JdbcUtils.getDataSource();
	private Connection conn=JdbcUtils.getConnection();
	public void addOrder(Orders orders) {
		//添加订单
		QueryRunner qr=new QueryRunner(ds);
		String sql="insert into orders (id,date,totalprice,status,user_id)values(?,?,?,?,?)";
		Object[] params={orders.getId(),orders.getDate(),orders.getTotalPrice(),orders.getStatus(),orders.getUser().getId()};
		try {
			conn.setAutoCommit(false);
			qr.update(sql, params);
			//添加订单项
			sql="insert into orderitem(id,num,price,book_id,orders_id)values(?,?,?,?,?)";
			Set<OrderItem> o=orders.getSet();
			for(OrderItem item:orders.getSet()){
				Object[] param={item.getId(),item.getNum(),item.getPrice(),item.getBook().getId(),orders.getId()};
				qr.update(sql, param);
//				orders.getSet().add(item);
			}
			
			conn.commit();
		} catch (Exception e) {
			if (conn!=null) {
				try {
					conn.rollback();
					conn.commit();
				} catch (SQLException e1) {
					throw new RuntimeException(e);
				}
			}
			throw new RuntimeException(e);
		}
	}

	public List<Orders> findByStatus(int status) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="select * from orders where status=?";
		Object[] params={status};
		try {
			return (List<Orders>) qr.query(sql, new BeanListHandler(Orders.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<OrderItem> findOrderItem(String orderid) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="select * from orderitem where orders_id=?";
		Object[] params={orderid};
		try {
			return (List<OrderItem>) qr.query(sql, new BeanListHandler(OrderItem.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Orders> findOrders(String userid) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="select * from orders where user_id=?";
		Object[] params={userid};
		try {
			return (List<Orders>) qr.query(sql, new BeanListHandler(Orders.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void updateOrders(Orders orders) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="update orders set status=? where id=?";
		Object[] params={orders.getStatus(),orders.getId()};
		try {
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Book> findBookByOrderItemId(String orderitemid) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="select * from book where id=(select book_id from orderitem where id=?)";
		Object[] params={orderitemid};
		try {
			return (List<Book>) qr.query(sql, new BeanListHandler(Book.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Orders findOrder(String orderid) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="select * from orders where id=?";
		Object[] params={orderid};
		try {
			return (Orders) qr.query(sql, new BeanHandler(Orders.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public User findUserByOrderId(String orderid) {
		
		QueryRunner qr=new QueryRunner(ds);
		String sql="select * from user where id=(select user_id from orders where id=?)";
		Object[] params={orderid};
		try {
			return (User) qr.query(sql, new BeanHandler(User.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Orders findOrderByOrderItemId(String orderitemid) {

		QueryRunner qr=new QueryRunner(ds);
		String sql="select * from orders where id=(select orders_id from orderitem where id=?)";
		Object[] params={orderitemid};
		try {
			return (Orders) qr.query(sql, new BeanHandler(Orders.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
