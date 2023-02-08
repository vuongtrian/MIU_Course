package lesson9.labs.prob1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> list = Stream.of("Bill", "Thomas", "Mary");
        list.collect(Collectors.toList()).forEach(s -> System.out.print(s + ","));
    }
}
