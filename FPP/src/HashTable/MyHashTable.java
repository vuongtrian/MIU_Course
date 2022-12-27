package HashTable;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashTable {
    private int size;
    private static final int INITIAL_SIZE = 10;
    private int tableSize;
    private LinkedList[] table;

    public MyHashTable() {
        this(INITIAL_SIZE);
    }

    public MyHashTable(int tableSize) {
        this.tableSize = tableSize;
        table = new LinkedList[tableSize];
        size = 0;
    }

    // support method
    private int hash(int bigNum) {
        bigNum = Math.abs(bigNum);
        return bigNum % tableSize;
    }

    public void put(Object key, Object value) {
        if (key == null) {
            return;
        }
        int hashcode = key.hashCode();
        int index = hash(hashcode);

        Entry e = new Entry(key, value);
        if (table[index] == null) {
            table[index] = new LinkedList();
        }
        table[index].add(e);
        size++;
    }

    public void putNoDuplicates(Object key, Object value) {
        if (key == null) {
            return;
        }
        int hashcode = key.hashCode();
        int index = hash(hashcode);

        Entry e = new Entry(key, value);
        boolean isExisting = false;
        if (table[index] != null) {
            for (Object ob : table[index]) {
                Entry en = (Entry) ob;
                if (en.key.equals(key)) {
                    isExisting = true;
                    en.value = value;
                }
            }
        }

        if (!isExisting) {
            if (table[index] == null) {
                table[index] = new LinkedList();
            }
            table[index].add(e);
            size++;
        }
    }

    public Object get(Object key) {
        if (key == null) {
            return null;
        }

        int hashcode = key.hashCode();
        int index = hash(hashcode);

        if (table[index] == null) {
            return null;
        }
        Entry e = null;
//        for(Iterator it = table[index].iterator(); it.hasNext();) {
//            e = (Entry) it.next();
//            if(e.key.equals(key)) {
//                return e.value;
//            }
//        }
        for (Object ob : table[index]) {
            e = (Entry) ob;
            if (e.key.equals(key)) {
                return e.value;
            }
        }

        return null;
    }

    public String toString() {
        String n = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                sb.append("Index[" + i + "] ");
                Entry next = null;
                for (Iterator it = table[i].iterator(); it.hasNext(); ) {
                    next = (Entry) it.next();
                    if (next.value != null) {
                        sb.append(next + n);
                    } else {
                        sb.append(next.key + "->null" + n);
                    }
                }
            }
        }
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    // create object
    private class Entry {
        private Object key;
        private Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyHashTable table = new MyHashTable();
        table.put("CS390", "FPP");
        table.put("CS401", "MPP");
        table.put("CS473", "Android");
        table.put("CS473", "Andriod Java");
        table.put("CS423", null);

        System.out.println(table.toString());
        System.out.println(table.size);

        System.out.println("Get: " + table.get("CS473").toString());
        ;

    }
}
