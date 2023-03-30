package Hadoop;

public class Pair<L,T> {
    private L length;
    private T count;

    public Pair(L length, T count) {
        this.length = length;
        this.count = count;
    }

    public L getLength() {
        return length;
    }

    public void setLength(L length) {
        this.length = length;
    }

    public T getCount() {
        return count;
    }

    public void setCount(T count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "[" + length + ", " + count + ']';
    }
}
