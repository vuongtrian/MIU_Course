package customers;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AgeIterator<T> implements Iterator<T> {
    private final List<T> list;
    private Comparator<T> comparator;

    public AgeIterator(List<T> list, Comparator<T> comparator) {
        this.list = list;
       this.comparator = comparator;
    }

    public void sort() {
        list.sort(this.comparator);
    }

    @Override
    public boolean hasNext() {
        return list.iterator().hasNext();
    }

    @Override
    public T next() {
        return list.iterator().next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
