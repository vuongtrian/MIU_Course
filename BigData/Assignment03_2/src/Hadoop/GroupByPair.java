package Hadoop;

import java.util.Arrays;

public class GroupByPair {
    private char key;
    private Pair[] values;
    int size = 1;
    int index = 0;

    public GroupByPair(char key) {
        this.key = key;
        values = new Pair[size];
    }

    public void resize() {
        size++;
        Pair[] newArr = new Pair[size];
        System.arraycopy(values, 0, newArr, 0, values.length);
        values = newArr;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public Pair[] getValues() {
        return values;
    }

    public void setValues(Pair[] values) {
        this.values = values;
    }

    public void addValue(Pair value) {
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
