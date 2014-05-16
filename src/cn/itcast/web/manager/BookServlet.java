package cn.itcast.web.manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import cn.itcast.domain.Book;
import cn.itcast.domain.Category;
import cn.itcast.domain.Page;
import cn.itcast.service.BookService;
import cn.itcast.service.CategoryService;
import cn.itcast.utils.DaoFactory;
import cn.itcast.utils.IDUtils;

public class BookServlet extends HttpServlet {

	private CategoryService categoryService=DaoFactory.getInstance().createDao("cn.itcast.service.CategoryServiceImpl", CategoryService.class);
	private BookService bookService=DaoFactory.getInstance().createDao("cn.itcast.service.BookServiceImpl", BookService.class);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method=request.getParameter("method");
		if (method.equals("save")) {
			saveBook(request,response);
		}else if (method.equals("add")) {
			addBook(request,response);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}else if (method.equals("list")) {
			listBook(request,response);
			request.getRequestDispatcher("/manager/listBook.jsp").forward(request, response);
		}else if (method.equals("listImage")) {
			listImageBook(request,response);
			request.getRequestDispatcher("/manager/listImage.jsp").forward(request, response);
		}else if (method.equals("delete")) {
			deleteBook(request,response);
		}else if (method.equals("showUpdate")) {
			showUpdateBook(request,response);
			request.getRequestDispatcher("/manager/updateBook.jsp").forward(request, response);
		}else if (method.equals("update")) {
			updateBook(request,response);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	private void updateBook(HttpServletRequest request,
			HttpServletResponse response) {
		
		Book book=bookService.find(request.getParameter("id"));
		//文件上传
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		upload.setFileSizeMax(10*1024*1024);
		if (!upload.isMultipartContent(request)) {
			return;
		} else {
			try {
				List<FileItem> list=upload.parseRequest(request);
				for (FileItem fileItem : list) {
					if (fileItem.isFormField()) {
						String name=fileItem.getFieldName();
						String value=fileItem.getString("utf-8");
						if (name.equals("category")) {
							book.setCategory(categoryService.find(value));
						} else {
							BeanUtils.copyProperty(book, name, value);
						}
					} else {
						String fileName=fileItem.getName();
						fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
						
						book.setOldname(fileName);
						fileName=IDUtils.generateID()+"_"+fileName;
						book.setImage(fileName);
						
						String realPath=getServletContext().getRealPath("/images");
						String realName=realPath+"\\"+fileName;
						
						InputStream in=fileItem.getInputStream();
						OutputStream out=new FileOutputStream(realName);
						int len=0;
						byte[] buf=new byte[1024];
						while ((len=in.read(buf))>-1) {
							out.write(buf, 0, len);
							out.flush();
						}
						
						in.close();
						out.close();
						fileItem.delete();
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		bookService.update(book);
		request.setAttribute("message", "修改成功");
	}

	private void showUpdateBook(HttpServletRequest request,
			HttpServletResponse response) {
		
		String id=request.getParameter("id");
		Book book=bookService.find(id);
		request.setAttribute("book", book);
		List<Category> list=categoryService.getAll();
		request.setAttribute("list", list);
	}

	private void deleteBook(HttpServletRequest request,
			HttpServletResponse response) {
		
		String id=request.getParameter("id");
		bookService.delete(id);
		try {
			request.setAttribute("message","删除成功");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void listImageBook(HttpServletRequest request,
			HttpServletResponse response) {
		String image=request.getContextPath()+"\\images\\"+request.getParameter("imageName");
		request.setAttribute("image", image);
	}

	private void listBook(HttpServletRequest request,
			HttpServletResponse response) {
		
		String currentPage=request.getParameter("currentPage");
		Page page=bookService.getPageRecord(currentPage);
		request.setAttribute("page", page);
		
	}

	private void addBook(HttpServletRequest request,
			HttpServletResponse response) {
		
		Book book=new Book();
		//文件上传
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		upload.setFileSizeMax(10*1024*1024);
		if (!upload.isMultipartContent(request)) {
			return;
		} else {
			try {
				List<FileItem> list=upload.parseRequest(request);
				for (FileItem fileItem : list) {
					if (fileItem.isFormField()) {
						String name=fileItem.getFieldName();
						String value=fileItem.getString("utf-8");
						if (name.equals("category")) {
							book.setCategory(categoryService.find(value));
						} else {
							BeanUtils.copyProperty(book, name, value);
						}
					} else {
						String fileName=fileItem.getName();
						fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
						
						book.setOldname(fileName);
						fileName=IDUtils.generateID()+"_"+fileName;
						book.setImage(fileName);
						
						String realPath=getServletContext().getRealPath("/images");
						String realName=realPath+"\\"+fileName;
						
						InputStream in=fileItem.getInputStream();
						OutputStream out=new FileOutputStream(realName);
						int len=0;
						byte[] buf=new byte[1024];
						while ((len=in.read(buf))>-1) {
							out.write(buf, 0, len);
							out.flush();
						}
						
						in.close();
						out.close();
						fileItem.delete();
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		book.setId(IDUtils.generateID());
		bookService.add(book);
		request.setAttribute("message", "添加成功");
		
	}

	private void saveBook(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			
			List<Category>  list=categoryService.getAll();
			request.setAttribute("list",list);
			request.getRequestDispatcher("/manager/addBook.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
