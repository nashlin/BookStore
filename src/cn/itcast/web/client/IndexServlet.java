package cn.itcast.web.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Book;
import cn.itcast.domain.Category;
import cn.itcast.domain.Page;
import cn.itcast.service.BookService;
import cn.itcast.service.CategoryService;
import cn.itcast.utils.DaoFactory;

public class IndexServlet extends HttpServlet {

	private BookService bookService=DaoFactory.getInstance().createDao("cn.itcast.service.BookServiceImpl", BookService.class);
	private CategoryService categoryService=DaoFactory.getInstance().createDao("cn.itcast.service.CategoryServiceImpl", CategoryService.class);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method=request.getParameter("method");
		if (method.equals("listCategory")) {
			listCategory(request,response);
			request.getRequestDispatcher("/client/left.jsp").forward(request, response);
		}else if (method.equals("listBook")) {
			listBook(request,response);
			request.getRequestDispatcher("/client/body.jsp").forward(request, response);
		}
	}

	private void listBook(HttpServletRequest request,
			HttpServletResponse response) {
		String currentPage=request.getParameter("currentPage");
		String categoryid=request.getParameter("categoryid");
		Page page=null;
		if (categoryid==null||categoryid.equals("")) {
			page=bookService.getPageRecord(currentPage);
		}else{
			page=bookService.getCategoryPageRecord(currentPage, categoryid);
			request.setAttribute("categoryid",categoryid);
		}
		request.setAttribute("page", page);
	}

	private void listCategory(HttpServletRequest request,
			HttpServletResponse response) {
		
		List<Category> list=categoryService.getAll();
		request.setAttribute("category", list);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
