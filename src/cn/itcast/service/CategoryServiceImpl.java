package cn.itcast.service;

import java.util.List;

import cn.itcast.dao.CategoryDao;
import cn.itcast.dao.CategoryDaoImpl;
import cn.itcast.domain.Category;
import cn.itcast.utils.DaoFactory;
import cn.itcast.utils.IDUtils;

public class CategoryServiceImpl implements CategoryService {

	private  CategoryDao dao=new CategoryDaoImpl();
	public void addCategory(Category c) {
		
		c.setId(IDUtils.generateID());
		dao.addCategory(c);
	}

	public void deleteCategory(String id) {
		
		dao.deleteCategory(id);

	}

	public Category find(String id) {
		
		return dao.find(id);
	}

	public List<Category> getAll() {

		return dao.getAll();
	}

	public void updateCategory(Category c) {
		
		dao.updateCategory(c);

	}

}
