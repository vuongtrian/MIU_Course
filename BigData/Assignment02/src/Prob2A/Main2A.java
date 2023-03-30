package Prob2A;

import java.util.List;

public class Main2A {

    public static void main(String[] args) {
	    String str = Utility.readFromFile("input.txt");

        Mapper m = new Mapper();
        m.mapper(str);

        List<Pair> mapperRes = m.getListWord();

        StringBuilder sb1 = new StringBuilder();
        for (Pair p : mapperRes) {
           sb1.append(p.toString() + "\n");
        }

        Utility.writeToFile("testDataForW1D1.txt", sb1.toString());

        Reduce r = new Reduce();
        r.shuffle(mapperRes);
        r.reduce(r.getGroupByPairList());
        List<Pair> reduceRes = r.getPairList();


        StringBuilder sb2 = new StringBuilder();
        for(Pair p : reduceRes) {
            sb2.append(p.toString() + "\n");
        }
        Utility.writeToFile("SampleOutputOfW2D2PartA.txt", sb2.toString());


    }
}
