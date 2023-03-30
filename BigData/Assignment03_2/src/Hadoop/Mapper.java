package Hadoop;

import java.util.HashMap;

public class Mapper {
    private HashMap<Character, Pair> listWord;

    public Mapper() {
        listWord = new HashMap();
    }

    public HashMap getListWord() {
        return listWord;
    }

    public void mapper(String text) {
        if(text.isEmpty()) {
            throw new NullPointerException("input is empty");
        }

        String[] strArray = text.replace("-", " ").replaceAll("[-+.^:?\"',]","").split("\\W");
        for(String s : strArray) {
            s = s.toLowerCase();
            char key = s.charAt(0);
            int length = s.length();
            if(!listWord.containsKey(key)) {
                Pair<Integer, Integer> value = new Pair<>(length, 1);
                listWord.put(key,value);
            } else {
                Pair<Integer, Integer> value = listWord.get(key);
                value.setLength(value.getLength() + length);
                value.setCount(value.getCount() + 1);
                listWord.put(key, value);
            }
        }
    }
}
