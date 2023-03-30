package Hadoop;

import java.util.HashMap;

public class WordCount {
    private Mapper[] mappers;
    private Reducer[] reducers;

    public WordCount(int m, int r) {
        mappers = new Mapper[m];
        reducers = new Reducer[r];
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

    public int getPartition(String key){
        return (int) key.hashCode() % reducers.length;
    }

    public void shuffer(Mapper[] mappers) {
        for (Mapper m: mappers) {
            HashMap<String, Integer> listWord = m.getListWord();
            for (String s: listWord.keySet()) {
                int hashIndex = getPartition(s);
                for (int i = 0; i < reducers.length; i++) {
                    if(hashIndex == i) {
                        if(reducers[i] == null) {
                            reducers[i] = new Reducer();
                            reducers[i].getListWord().put(s, listWord.get(s));
                        } else {
                            if(reducers[i].getListWord().containsKey(s)) {
                                reducers[i].getListWord().put(s, listWord.get(s)+reducers[i].getListWord().get(s));
                            } else {
                                reducers[i].getListWord().put(s, listWord.get(s));
                            }

                        }

                    }
                }
            }
        }
    }

}
