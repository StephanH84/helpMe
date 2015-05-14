package com.stephan.dao;

import java.util.List;

import com.stephan.model.User;

public interface UserDAO {
 
    public void save(User user);
     
    public List<User> list();
 
    public User findById(int id);
}