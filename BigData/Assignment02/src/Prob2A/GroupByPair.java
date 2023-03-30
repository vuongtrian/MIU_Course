package Prob2A;

import java.util.Arrays;
import java.util.List;

public class GroupByPair<K> {
    private K key;
    private int[] values;
    int size = 1;
    int index = 0;

    public GroupByPair(K key) {
        this.key = key;
        values = new int[size];
    }

    public void resize() {
        size++;
        int[] newArr = new int[size];
        System.arraycopy(values, 0, newArr, 0, values.length);
        values = newArr;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public void addValue(int value) {
        if(index == 0) {
            values[index] = value;
        } else {
            resize();
            values[index] = value;
        }
        index++;
    }

    @Override
    public String toString() {
        return "(" + key +
                ", " + Arrays.toString(values) +
                ')';
    }
}
