package com.stephan.dao;

import java.util.List;

import com.stephan.model.Question;

public interface QuestionDAO {
 
    public void save(Question question);
     
    public List<Question> list();
     
    public Question findById(int id);
}