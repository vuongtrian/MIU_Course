package Assignment_Lession_7_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        Student s1 = new Student("2", "Jack");
        Student s2 = new Student("1", "David");
        Student s3 = new Student("5", "Sarah");
        Student s4 = new Student("4", "Steve");
        Student s5 = new Student("3", "Sophia");

        List<Student> listStudent = new ArrayList<>();
        listStudent.add(s1);
        listStudent.add(s2);
        listStudent.add(s3);
        listStudent.add(s4);
        listStudent.add(s5);

        Comparator<Student> compareById = (Student temp1, Student temp2) -> temp1.getId().compareTo(temp2.getId());
        Collections.sort(listStudent,compareById);

        for (Student s: listStudent) {
            System.out.println(s.getId());
        }

        for (int i = 0; i < listStudent.size() - 1; i++) {
            if (listStudent.get(i).compareName(listStudent.get(i+1)) == 1) {
                Collections.swap(listStudent, i , i+1);
            }
        }

        for (Student s: listStudent) {
            System.out.println(s.getLastName());
        }
    }


//    @Override
//    public int compare(Student o1, Student o2) {
//        return o1.getId().compareTo(o2.getId());
//    }
}
