package Hadoop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordCount {
    private Mapper[] mappers;
    private Reducer[] reducers;
    private List<GroupByPair>[] groupByPairs;

    public WordCount(int m, int r) {
        mappers = new Mapper[m];
        reducers = new Reducer[r];
        groupByPairs = new List[r];
    }

    public Mapper[] getMappers() {
        return mappers;
    }

    public void setMappers(Mapper[] mappers) {
        this.mappers = mappers;
    }

    public Reducer[] getReducers() {
        return reducers;
    }

    public void setReducers(Reducer[] reducers) {
        this.reducers = reducers;
    }

    public List<GroupByPair>[] getGroupByPairs() {
        return groupByPairs;
    }

    public int getPartition(String key){
        return (int) key.hashCode() % reducers.length;
    }

    public void shuffer(Mapper[] mappers) {
        for (Mapper m: mappers) {
            HashMap<Character, Pair> listWord = m.getListWord();
            for (char s: listWord.keySet()) {
                int hashIndex = getPartition(String.valueOf(s));
                for (int i = 0; i < groupByPairs.length; i++) {
                    if(hashIndex == i) {
                        if(groupByPairs[i] == null) {
                            groupByPairs[i] = new ArrayList<>();
                            GroupByPair gbp = new GroupByPair(s);
                            gbp.addValue(listWord.get(s));
                            groupByPairs[i].add(gbp);
                        } else {
                            if(isExist(groupByPairs[i], s) != -1) {
                                int index = isExist(groupByPairs[i], s);
                                GroupByPair gbp = groupByPairs[i].get(index);
                                gbp.addValue(listWord.get(s));
                                groupByPairs[i].set(index, gbp);
                            } else {
                                GroupByPair gbp = new GroupByPair(s);
                                gbp.addValue(listWord.get(s));
                                groupByPairs[i].add(gbp);
                            }
                        }
                    }
                }
            }
        }
        mapper();
    }

    public int isExist(List<GroupByPair> list, char c) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getKey() == c) {
                return i;
            }
        }
        return -1;
    }

    public void mapper() {
        for (int i = 0; i < reducers.length; i++) {
            for (GroupByPair gbp: groupByPairs[i]) {
                int sumLength = 0;
                int sumCount = 0;
                Pair[] values = gbp.getValues();
                for (Pair<Integer, Integer> p : values) {
                    sumLength += p.getLength();
                    sumCount += p.getCount();
                }
                if(reducers[i] == null) {
                    reducers[i] = new Reducer();
                    reducers[i].getListWord().put(gbp.getKey(), (double)sumLength/sumCount);
                } else {
                    reducers[i].getListWord().put(gbp.getKey(), (double)sumLength/sumCount);
                }
            }

//            for (Pair<Integer, Integer> p : values) {
//                sumLength += p.getLength();
//                sumCount += p.getCount();
//            }
//            if(reducers[i] == null) {
//                reducers[i] = new Reducer();
//                reducers[i].getListWord().put(groupByPairArray[i].getKey(), (long)sumLength/sumCount);
//            } else {
//                reducers[i].getListWord().put(groupByPairArray[i].getKey(), (long)sumLength/sumCount);
//            }

        }
    }

}
