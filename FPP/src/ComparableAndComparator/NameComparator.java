package ComparableAndComparator;

import java.util.Comparator;

public class NameComparator implements Comparator<DeptEmployee> {
    @Override
    public int compare(DeptEmployee o1, DeptEmployee o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
