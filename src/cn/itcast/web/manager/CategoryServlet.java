package cn.itcast.web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Category;
import cn.itcast.service.CategoryService;
import cn.itcast.service.CategoryServiceImpl;

public class CategoryServlet extends HttpServlet {

	private CategoryService service=new CategoryServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method=request.getParameter("method");
		if (method.equals("add")) {
			try {
				addCategory(request);
				request.setAttribute("message", "添加成功");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			} catch (Exception e) {
				request.setAttribute("message", "添加失败");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			}
		}else if (method.equals("update")) {
			updateCategory(request);
			request.getRequestDispatcher("/manager/updateCategory.jsp").forward(request, response);
		}else if (method.equals("delete")) {
			deleteCategory(request);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}else if (method.equals("find")) {
			findCategory(request);
		}else if (method.equals("list")) {
			listCategory(request);
			request.getRequestDispatcher("/manager/listCategory.jsp").forward(request, response);
		}else if (method.equals("save")) {
			saveCategory(request);
			request.getRequestDispatcher("/manager/listCategory.jsp").forward(request, response);
		}
	}

	private void saveCategory(HttpServletRequest request) {

		String id=request.getParameter("id");
		Category c=service.find(id);
		c.setName(request.getParameter("name"));
		c.setDescription(request.getParameter("description"));
		service.updateCategory(c);
		List<Category> list=service.getAll();
		request.setAttribute("list", list);
	}

	private void listCategory(HttpServletRequest request) {
		
		List<Category> list=service.getAll();
		request.setAttribute("list", list);
		
	}

	private void findCategory(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	private void deleteCategory(HttpServletRequest request) {
		
		String id=request.getParameter("id");
		service.deleteCategory(id);
		request.setAttribute("message", "删除成功");
	}

	private void updateCategory(HttpServletRequest request) {
		
		String id=request.getParameter("id");
		Category c=service.find(id);
		request.setAttribute("c", c);
		
	}

	private void addCategory(HttpServletRequest request) {
		
		Category c=new Category();
		c.setName(request.getParameter("name"));
		c.setDescription(request.getParameter("description"));
		
		service.addCategory(c);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
