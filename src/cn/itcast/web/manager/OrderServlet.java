package cn.itcast.web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Book;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.Orders;
import cn.itcast.domain.User;
import cn.itcast.service.OrderService;
import cn.itcast.utils.DaoFactory;

public class OrderServlet extends HttpServlet {

	private OrderService orderService=DaoFactory.getInstance().createDao("cn.itcast.service.OrderServiceImpl", OrderService.class);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method=request.getParameter("method");
		if (method.equals("hasSend")) {
			hasSendOrder(request,response);
			request.getRequestDispatcher("/manager/showHasSendOrder.jsp").forward(request, response);
		}//unSend
		if (method.equals("unSend")) {
			unSendOrder(request,response);
			request.getRequestDispatcher("/manager/showUnSendOrder.jsp").forward(request, response);
		}//showOrderItem
		if (method.equals("showOrderItem")) {
			showOrderItem(request,response);
			request.getRequestDispatcher("/manager/showCustomerOrderItem.jsp").forward(request, response);
		}//sureSend
		if (method.equals("sureSend")) {
			sureSend(request,response);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	private void sureSend(HttpServletRequest request,
			HttpServletResponse response) {

		String orderid=request.getParameter("orderid");
		Orders orders=orderService.findOrder(orderid);
		orders.setStatus(1);
		orderService.updateOrders(orders);
		request.setAttribute("message","下单成功");
	}

	private void showOrderItem(HttpServletRequest request,
			HttpServletResponse response) {
		
		String orderid=request.getParameter("orderid");
		List<OrderItem> list=orderService.findOrderItem(orderid);
		for (OrderItem item : list) {
			List<Book> books=orderService.findBookByOrderItemId(item.getId());
			for (Book book : books) {
				item.setBook(book);
			}
		}
		
		Orders orders=orderService.findOrder(orderid);
		request.setAttribute("list", list);
		request.setAttribute("orders", orders);
		
	}

	private void unSendOrder(HttpServletRequest request,
			HttpServletResponse response) {
		
		List<Orders> list=orderService.findByStatus(0);
		for (Orders order : list) {
			User user=orderService.findUserByOrderId(order.getId());
			order.setUser(user);
		}
		request.setAttribute("list", list);
		
	}

	private void hasSendOrder(HttpServletRequest request,
			HttpServletResponse response) {
		
		List<Orders> list=orderService.findByStatus(1);
		for (Orders order : list) {
			User user=orderService.findUserByOrderId(order.getId());
			order.setUser(user);
		}
		request.setAttribute("list", list);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
