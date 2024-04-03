package customers;

import java.util.Iterator;
import java.util.List;

public class OddPositionIterator <T> implements Iterator<T> {
    private final List<T> list;
    private int position;

    public OddPositionIterator(List<T> list) {
        this.list = list;
        this.position = 0;
    }

    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        position++;
        return position < list.size()-1;
    }

    @Override
    public T next() {
        return list.get(position ++);
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
