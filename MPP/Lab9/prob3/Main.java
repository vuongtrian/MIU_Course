package lesson9.labs.prob3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static int countWords(List<String> words, char c, char d, int len) {
       return words.stream()
                .filter(name -> name.contains("" + c))
                .filter(name -> !name.contains("" + d))
                .filter(name -> name.length() == len)
               .collect(Collectors.toList())
               .size();
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Andy");
        words.add("Jack");
        words.add("Bob");
        words.add("Samy");

        int count = countWords(words, 'a', 'd', 4);
        System.out.println(count);
    }
}
