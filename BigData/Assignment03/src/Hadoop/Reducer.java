package Hadoop;

import java.util.HashMap;

public class Reducer {
    private HashMap<String, Integer> listWord;

    public Reducer() {
        listWord = new HashMap<>();
    }

    public HashMap<String, Integer> getListWord() {
        return listWord;
    }
}
