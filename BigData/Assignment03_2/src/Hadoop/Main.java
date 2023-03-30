package Hadoop;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
//        read file
        String str1 = Utility.readFromFile("input_1.txt");
        String str2 = Utility.readFromFile("input_2.txt");
        String str3 = Utility.readFromFile("input_3.txt");
        String str4 = Utility.readFromFile("input_4.txt");

//        mapper process & print to output
        Mapper m1 = new Mapper();
        m1.mapper(str1);
        HashMap listWord1 = m1.getListWord();
        String output1 = Utility.convertToString(listWord1);
        Utility.writeToFile("mapperOutput_1", output1);

        Mapper m2 = new Mapper();
        m2.mapper(str2);
        HashMap listWord2 = m2.getListWord();
        String output2 = Utility.convertToString(listWord2);
        Utility.writeToFile("mapperOutput_2", output2);

        Mapper m3 = new Mapper();
        m3.mapper(str3);
        HashMap listWord3 = m3.getListWord();
        String output3 = Utility.convertToString(listWord3);
        Utility.writeToFile("mapperOutput_3", output3);

        Mapper m4 = new Mapper();
        m4.mapper(str4);
        HashMap listWord4 = m4.getListWord();
        String output4 = Utility.convertToString(listWord4);
        Utility.writeToFile("mapperOutput_4", output4);

//        shuffer process
        WordCount wc = new WordCount(4,3);
        Mapper[] mapperArray = {m1,m2,m3,m4};
        wc.setMappers(mapperArray);
        wc.shuffer(wc.getMappers());
        wc.mapper();

//        mapper process & print to output
        Reducer[] reducerArray = wc.getReducers();
        for (int i = 0; i < reducerArray.length; i++) {
            Utility.writeToFile("reducerOutput_" + (i+1), Utility.convertToString(reducerArray[i].getListWord()));
        }
    }
}
