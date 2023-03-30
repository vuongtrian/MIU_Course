package Prob1;

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
        String[] strArray = text.replaceAll("[-+.^:?,]","").split(" ");
        for (String s : strArray) {
            listWord.add(new Pair(s.toLowerCase()));
        }
    }
}
