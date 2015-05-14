package com.stephan.dao;

import java.util.List;

import com.stephan.model.Answer;

public interface AnswerDAO {
 
    public void save(Answer answer);
     
    public List<Answer> list();
     
    public Answer findById(int id);
}