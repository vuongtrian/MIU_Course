package ComparableAndComparator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DeptEmployee[] data = DeptEmployeeData.getDeptData();
        System.out.println("===Original array===");
        for(DeptEmployee e : data) {
            System.out.println(e);
        }
        System.out.println("===Use Comparator===");
        Arrays.sort(data, new NameComparator());
        for(DeptEmployee e : data) {
            System.out.println(e);
        }
    }
}
