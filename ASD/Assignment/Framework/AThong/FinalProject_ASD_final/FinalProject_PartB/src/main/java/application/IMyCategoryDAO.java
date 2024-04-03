package application;

import com.FinalProject.Category;

public interface IMyCategoryDAO {

    public Category find(int id);
    public void save(Category category);
}
