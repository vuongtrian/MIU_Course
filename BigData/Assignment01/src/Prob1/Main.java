package Prob1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    String str = Utility.readFromFile("input.txt");

        Mapper m = new Mapper();
        m.mapper(str);

        List<Pair> output = m.getListWord();

        StringBuilder sb = new StringBuilder();
        for (Pair p : output) {
           sb.append(p.toString() + "\n");
        }

        Utility.writeToFile("testDataForW1D1.txt", sb.toString());
    }
}
