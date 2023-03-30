package Prob2A;

public class WordCount {
    private Mapper[] mappers;
    private Reduce[] reducers;

    public WordCount(int m, int r) {
        mappers = new Mapper[m];
        reducers = new Reduce[r];
    }

    public Mapper[] getMappers() {
        return mappers;
    }

    public void setMappers(Mapper[] mappers) {
        this.mappers = mappers;
    }

    public Reduce[] getReducers() {
        return reducers;
    }

    public void setReducers(Reduce[] reducers) {
        this.reducers = reducers;
    }

    public int getPartition(String key){
        return (int) key.hashCode() % reducers.length;
    }

}
