package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Category;

public interface CategoryDao {

	void addCategory(Category c);
	
	void deleteCategory(String id);
	
	void updateCategory(Category c);
	
	List<Category> getAll();
	
	Category find(String id);
}
