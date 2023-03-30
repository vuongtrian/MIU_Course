package Hadoop;

import java.util.HashMap;

public class Reducer {
    private HashMap<Character, Double> listWord;

    public Reducer() {
        listWord = new HashMap<>();
    }

    public HashMap<Character, Double> getListWord() {
        return listWord;
    }
}
