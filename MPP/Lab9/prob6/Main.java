package lesson9.labs.prob6;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Main {

    public static Set<String> union(List<Set<String>> sets) {
        return sets.stream().flatMap(Set::stream).collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        List<Set<String>> sets = Arrays.asList(
                Set.of("A", "B"),
                Set.of("D"),
                Set.of("1","3","5")
        );

        Set<String> allElements = union(sets);
        System.out.println(allElements);
    }
}
