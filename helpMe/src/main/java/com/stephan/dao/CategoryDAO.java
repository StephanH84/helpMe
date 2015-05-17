package com.stephan.dao;

import java.util.List;

import com.stephan.model.Category;
import com.stephan.model.User;

public interface CategoryDAO {
 
    public void save(Category category);
     
    public List<Category> list();
     
    public Category findById(int id);
    
    public void delete(int id);
}