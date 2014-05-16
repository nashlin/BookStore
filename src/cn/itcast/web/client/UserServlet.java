package cn.itcast.web.client;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Cart;
import cn.itcast.domain.CartItem;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.Orders;
import cn.itcast.domain.User;
import cn.itcast.service.OrderService;
import cn.itcast.service.UserService;
import cn.itcast.utils.DaoFactory;
import cn.itcast.utils.IDUtils;
import cn.itcast.utils.MD5Utils;

public class UserServlet extends HttpServlet {

	private UserService userService=DaoFactory.getInstance().createDao("cn.itcast.service.UserServiceImpl", UserService.class);
	private OrderService orderService=DaoFactory.getInstance().createDao("cn.itcast.service.OrderServiceImpl", OrderService.class);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method=request.getParameter("method");
		if (method.equals("register")) {
			register(request,response);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}if (method.equals("login")) {
			login(request,response);
		}if (method.equals("loginOut")) {
			loginOut(request,response);
		}if (method.equals("createOrder")) {
			createOrder(request,response);
		}
	}

	private void createOrder(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			//1.�ж��û��Ƿ���ڣ������ڣ���ʾ��½
			User user=(User) request.getSession().getAttribute("user");
			if (user==null) {
				request.setAttribute("message","���¼");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			//2.���ɶ����������ţ��µ����ڣ��ܽ�˭�ģ�����״̬0��δ��������1���ѷ���������������
			//3.���ɶ��������󣬹�����Ŀ��������Ʒ�ļ۸�
			Cart cart=(Cart) request.getSession().getAttribute("cart");
			Orders orders=new Orders();
			orders.setDate(new Date());
			orders.setId(IDUtils.generateID());
			orders.setTotalPrice(cart.getTotalPrice());
			orders.setStatus(0);
			orders.setUser(user);
		
			for(Map.Entry<String, CartItem> map:cart.getMap().entrySet()){
				OrderItem item=new OrderItem();
				item.setBook(map.getValue().getBook());
				item.setNum(map.getValue().getNum());
				item.setId(IDUtils.generateID());
				item.setPrice(map.getValue().getPrice());
				orders.getSet().add(item);
			}
				
			orderService.addOrder(orders);
			
			request.setAttribute("message", "���ɶ����ɹ�");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", "���ɶ���ʧ��");
			try {
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			} catch (Exception e1) {
			}
			throw new RuntimeException(e);
		}
	}

	private void loginOut(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("cart");
		
		try {
			request.getRequestDispatcher("/client/header.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		password=MD5Utils.MD(password);
		User user=userService.findUser(password, username);
		if (user!=null) {
			
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/client/header.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "��½ʧ��,�û��������������");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	private void register(HttpServletRequest request,
			HttpServletResponse response) {
		User user=new User();
		user.setAddress(request.getParameter("address"));
		user.setUsername(request.getParameter("username"));
		
		String password= MD5Utils.MD(request.getParameter("password"));
		user.setPassword(password);
		
		user.setCellphone(request.getParameter("cellphone"));
		user.setEmail(request.getParameter("email"));
		userService.addUser(user);
		
		request.setAttribute("message", "��ӳɹ�");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
