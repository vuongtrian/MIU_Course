package Prob4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static int countWords(List<String> words, char c, char d, int len) {
        List<String> filter = words.stream()
                .filter(item -> item.length() == len && item.contains(Character.toString(c)) && !item.contains(Character.toString(d)))
                .collect(Collectors.toList());
        return filter.size();
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Jack", "Bob", "Maya");
        System.out.println(countWords(words, 'a', 'k', 4));
    }
}
