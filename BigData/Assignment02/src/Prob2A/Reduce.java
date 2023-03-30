package Prob2A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reduce {
    List<GroupByPair> groupByPairList;
    List<Pair> pairList;

    public Reduce() {
        groupByPairList = new ArrayList<>();
        pairList = new ArrayList<>();
    }

    public void shuffle(List<Pair> pairList) {
        if (pairList.isEmpty()) {
            throw new NullPointerException("empty data");
        }
        for (Pair p: pairList) {
            if(isExist(p) == -1) {
                GroupByPair gp = new GroupByPair(p.getKey());
                gp.addValue(p.getValue());
                groupByPairList.add(gp);
            } else {
                int index = isExist(p);
                GroupByPair cur = groupByPairList.get(index);
                cur.addValue(p.getValue());
            }
        }
    }

    public void reduce(List<GroupByPair> input) {
        for(GroupByPair gp : input) {
            Pair p = new Pair(gp.getKey());
            p.setValue(Arrays.stream(gp.getValues()).sum());
            pairList.add(p);
        }
    }

    public int isExist (Pair p) {
        for (int i = 0; i < groupByPairList.size(); i++) {
            if(groupByPairList.get(i).getKey().equals(p.getKey())) {
                return i;
            }
        }
        return -1;
    }

    public List<GroupByPair> getGroupByPairList() {
        return groupByPairList;
    }

    public List<Pair> getPairList() {
        return pairList;
    }
}
