package Prob2A;

import java.util.ArrayList;
import java.util.List;

public class Main2B {
    public static void main(String[] args) {


//        read file
        String str1 = Utility.readFromFile("input2B_1.txt");
        String str2 = Utility.readFromFile("input2B_2.txt");
        String str3 = Utility.readFromFile("input2B_3.txt");


//        mapper process
        WordCount wc = new WordCount(3, 4);
        Mapper[] mappers = wc.getMappers();
        mappers[0] = new Mapper();
        mappers[0].mapper(str1);
        mappers[1] = new Mapper();
        mappers[1].mapper(str2);
        mappers[2] = new Mapper();
        mappers[2].mapper(str3);

//        reducer process
        Reduce[] reduces = wc.getReducers();
        for (int i = 0; i < reduces.length; i++) {
            reduces[i] = new Reduce();
        }
//        get list from mapper
        List<Pair> list1 = mappers[0].getListWord();
        List<Pair> list2 = mappers[1].getListWord();
        List<Pair> list3 = mappers[2].getListWord();

//        create new list
        List<Pair> newList1 = new ArrayList<>();
        List<Pair> newList2 = new ArrayList<>();
        List<Pair> newList3 = new ArrayList<>();
        List<Pair> newList4 = new ArrayList<>();

//        move value to correct list based on hash value
        addToNewList(list1, newList1, newList2, newList3, newList4, wc);
        addToNewList(list2, newList1, newList2, newList3, newList4, wc);
        addToNewList(list3, newList1, newList2, newList3, newList4, wc);

//        run reducer & write to file
        reduces[0].shuffle(newList1);
        reduces[0].reduce(reduces[0].getGroupByPairList());
        writeToFile(reduces[0].getPairList(), "OutputForReducer1");

        reduces[1].shuffle(newList2);
        reduces[1].reduce(reduces[1].getGroupByPairList());
        writeToFile(reduces[1].getPairList(), "OutputForReducer2");

        reduces[2].shuffle(newList3);
        reduces[2].reduce(reduces[2].getGroupByPairList());
        writeToFile(reduces[2].getPairList(), "OutputForReducer3");

        reduces[3].shuffle(newList4);
        reduces[3].reduce(reduces[3].getGroupByPairList());
        writeToFile(reduces[3].getPairList(), "OutputForReducer4");



    }

    public static void addToNewList (List<Pair> mapperList, List<Pair> l1, List<Pair> l2, List<Pair> l3, List<Pair> l4, WordCount wc) {
        for(Pair p : mapperList) {
            int hashIndex = wc.getPartition(p.getKey().toString());
            switch (hashIndex) {
                case 0:
                    l1.add(p);
                    break;
                case 1:
                    l2.add(p);
                    break;
                case 2:
                    l3.add(p);
                    break;
                case 3:
                    l4.add(p);
                    break;
                default:
                    break;
            }
        }
    }

    public static void writeToFile(List<Pair> input, String fileName) {
        StringBuilder sb = new StringBuilder();
        for(Pair p : input) {
            sb.append(p.toString() + "\n");
        }
        Utility.writeToFile(fileName, sb.toString());
    }
}
