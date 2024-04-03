package application;

import com.FinalProject.Category;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MyCategoryDAO2 implements IMyCategoryDAO {
    private Map<Integer, Category> categories = new HashMap<Integer, Category>();
    public Category find(int id){
        return categories.get(id);
    }

    public void save(Category category){
    	System.out.println("Use MyCategoryDAO2");
        categories.put(category.getId(), category);
        System.out.println("New category: " + category);
    }
}
