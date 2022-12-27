package Assignment_Lession_10;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Les_10_1 {
    public static void main(String[] args) {
        MyStringList list = new MyStringList();
        list.add("Binh");
        list.add("Long");
        list.add("An");
        list.add("Trang");
        System.out.println("Original List: " + list.toString() + " - Size: " + list.size());
        list.insert("Anh", 3);
        System.out.println("List after add Anh to pos 3: " + list.toString() + " - Size: " + list.size());
        list.remove("Long");
        System.out.println("List after remove Long: " + list.toString() + " - Size: " + list.size());
        list.sort();
        System.out.println("List after sort: " + list.toString() + " - Size: " + list.size());

        list.remove("An"); list.remove("Anh");list.remove("Binh"); list.remove("Trang");
        System.out.println("List after remove all: " + list.toString() + " - Size: " + list.size());

    }



}

class MyStringList {
    private final int INITIAL_LENGTH = 4;
    private String[] strArray;
    private int size;

    public MyStringList() {
        strArray = new String[INITIAL_LENGTH];
        size = 0;
    }

    // Add element in last
    public void add(String s) {
        if (s == null) {
            return;
        }
        if (size == strArray.length) {
            resize();
        }
        strArray[size++] = s;
    }

    public String get(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        return strArray[i];
    }

    public boolean find(String s) {
        if (s == null) {
            return false;
        }
        for (String test : strArray) {
            if (test.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void insert(String s, int pos) {
        if (s == null || pos < 0 || pos >= size) {
            return;
        }
        String[] temp = new String[strArray.length + 1];
        System.arraycopy(strArray, 0, temp, 0, pos);
        temp[pos] = s;
        System.arraycopy(strArray, pos, temp, pos + 1, strArray.length - pos);
        strArray = temp;
        size++;
    }

    public boolean remove(String s) {
        if (size == 0) {
            return false;
        }
        if (s == null) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (strArray[i].equals(s)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        String[] temp = new String[strArray.length];
        System.arraycopy(strArray, 0, temp, 0, index);
        System.arraycopy(strArray, index + 1, temp, index, strArray.length - (index + 1));
        strArray = temp;
        --size;
        return true;
    }

    public String toString() {
        if(size == 0) {
            return "List is empty";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(strArray[i] + ", ");
        }
        sb.append(strArray[size - 1] + "]");
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Object clone() {
        String[] temp = Arrays.copyOf(strArray, size);
        return temp;
    }

    private void resize() {
        System.out.println("resizing");
        int len = strArray.length;
        int newLen = len * 2;
        String[] temp = new String[newLen];
        System.arraycopy(strArray, 0, temp, 0, len);
        strArray = temp;
    }

    public void sort() {
        for (int i = 0; i < size-1; i++) {
           for (int j = i+1; j < size; j++) {
               if(strArray[i].compareTo(strArray[j]) > 0) {
                   String temp = strArray[i];
                   strArray[i] = strArray[j];
                   strArray[j] = temp;
               }
           }
        }
    }


}