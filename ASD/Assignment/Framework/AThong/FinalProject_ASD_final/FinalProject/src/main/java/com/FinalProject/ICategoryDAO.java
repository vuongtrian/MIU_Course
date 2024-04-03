package com.FinalProject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface ICategoryDAO {
    public void save(Category category);

    public Category find(int id);

    public void remove(int id);
}
