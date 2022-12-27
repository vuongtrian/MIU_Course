package Assignment_Lession_12;

import java.util.HashMap;
import java.util.List;

public class Admin {

    public static HashMap<Key, Student> processStudents(List<Student> students) {
        HashMap<Key,Student> hm = new HashMap<>();
        for (Student s: students) {
            Key key = new Key(s.getFirstName(), s.getLastName());
            hm.put(key,s);
        }
        return hm;
    }

    public static double computeAverageGPA(HashMap<Key, Student> maps) {
        double sumGPA = 0;
        for (Student s : maps.values()) {
            sumGPA += s.getGpa();
        }

        return sumGPA / maps.size();
    }
}
