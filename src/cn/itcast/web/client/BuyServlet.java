package cn.itcast.web.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.Orders;
import cn.itcast.service.BookService;
import cn.itcast.service.OrderService;
import cn.itcast.service.UserService;
import cn.itcast.utils.DaoFactory;

public class BuyServlet extends HttpServlet {

	private BookService bookService=DaoFactory.getInstance().createDao("cn.itcast.service.BookServiceImpl", BookService.class);
	private OrderService orderService=DaoFactory.getInstance().createDao("cn.itcast.service.OrderServiceImpl", OrderService.class);
	private UserService userService=DaoFactory.getInstance().createDao("cn.itcast.service.UserServiceImpl", UserService.class);
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method=request.getParameter("method");
		if (method.equals("buy")) {
			buyBook(request,response);
			request.getRequestDispatcher("/client/showCart.jsp").forward(request, response);
		}//listCart
		else if (method.equals("listCart")) {
			listCart(request,response);
			request.getRequestDispatcher("/client/showCart.jsp").forward(request, response);
		}//listOrder
		else if (method.equals("listOrder")) {
			listOrder(request,response);
			request.getRequestDispatcher("/client/showOrder.jsp").forward(request, response);
		}//showOrderItem
		else if (method.equals("showOrderItem")) {
			showOrderItem(request,response);
			request.getRequestDispatcher("/client/showOrderItem.jsp").forward(request, response);
		}
	}

	private void showOrderItem(HttpServletRequest request,
			HttpServletResponse response) {
		
		String orderid=request.getParameter("orderid");
		List<OrderItem> orderItem=orderService.findOrderItem(orderid);
		
		for (OrderItem item : orderItem) {
			List<Book> books=orderService.findBookByOrderItemId(item.getId());
			for (Book book : books) {
				item.setBook(book);
			}
		}
		
		Orders orders=orderService.findOrder(orderid);
		request.setAttribute("orderItem", orderItem);
		request.setAttribute("orders", orders);
	}

	private void listOrder(HttpServletRequest request,
			HttpServletResponse response) {
		
		String userid=request.getParameter("userid");
		List<Orders> orders=orderService.findOrders(userid);
		for (Orders order : orders) {
			order.setUser(userService.findUserById(userid));
		}
		
		request.setAttribute("orders", orders);
	}

	private void listCart(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session=request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		
	}

	private void buyBook(HttpServletRequest request,
			HttpServletResponse response) {
		
		String bookid=request.getParameter("bookid");
		HttpSession session=request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		if (cart==null) {
			cart=new Cart();
			cart.addBook(bookService.find(bookid));
			session.setAttribute("cart", cart);
		}else{
			cart.addBook(bookService.find(bookid));
			session.setAttribute("cart", cart);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
