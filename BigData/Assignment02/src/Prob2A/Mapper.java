package Prob2A;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    List<Pair> listWord;

    public Mapper() {
        listWord = new ArrayList<>();
    }

    public List<Pair> getListWord() {
        return listWord;
    }

    public void setListWord(List<Pair> listWord) {
        this.listWord = listWord;
    }

    public void mapper (String text) {
        if(text.isEmpty()) {
            throw new NullPointerException("input is empty");
        }

        String[] strArray = text.replace("-", " ").replaceAll("[-+.^:?\"',]","").split("\\W");
//        prob2A
//        for (String s : strArray) {
//            listWord.add(new Pair(s.toLowerCase()));
//        }

//        prob2B
        for (String s : strArray) {
            if(s.toLowerCase().length() == 3) {
                listWord.add(new Pair(s.toLowerCase()));
            }
        }
    }


}
