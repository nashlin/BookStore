package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Category;

public interface CategoryService {

	void addCategory(Category c);
	
	void deleteCategory(String id);
	
	void updateCategory(Category c);
	
	List<Category> getAll();
	
	Category find(String id);
}
