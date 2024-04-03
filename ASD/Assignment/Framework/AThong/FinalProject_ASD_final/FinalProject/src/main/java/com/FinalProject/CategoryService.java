package com.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    @Qualifier("myCategoryDAO")
    ICategoryDAO categoryDAO;


    public void addCategory(int id, String name){
        categoryDAO.save(new Category(id, name));
    }
    public Category getCategory(int id){
        return categoryDAO.find(id);
    }

}
