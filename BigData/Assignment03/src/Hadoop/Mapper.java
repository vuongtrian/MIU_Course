package Hadoop;

import java.util.HashMap;

public class Mapper {
    private HashMap<String, Integer> listWord;

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
            if(s.length() == 3) {
                if(!listWord.containsKey(s)) {
                    listWord.put(s, 1);
                } else {
                    listWord.put(s, listWord.get(s)+1);
                }
            }
        }
    }
}
