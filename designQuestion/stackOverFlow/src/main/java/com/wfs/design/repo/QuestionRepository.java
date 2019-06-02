package com.wfs.design.repo;

import com.wfs.design.bo.Question;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QuestionRepository {

    private int id ;
    private Set<Question>  questions =new HashSet<>();

    public boolean addQuestion(Question question){
        questions.add(question);
        return true;
    }
}
