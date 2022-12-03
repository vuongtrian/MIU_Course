package Lab_3_3;

import java.util.Arrays;

public class MyStringList {
	private final int INITIAL_LENGTH = 2;
	private String[] strArray; 
	private int size;
	
	public MyStringList() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;
	}
	
	public void add(String s){
		//implement
		if(s.isEmpty()) {
			return;
		}
		if(size >= strArray.length) {
			resize();
		}
		strArray[size] = s;
		size++;
	}
	
	public String get(int i){
		//implement
		if (i < 0 || i >= size) {
			return null;
		}
		return strArray[i];
	}
	
	public boolean find(String s){
		//implemement
		if (!s.isEmpty()) {
			for (int i = 0; i <= size; i++) {
				if (strArray[i].equals(s)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void insert(String s, int pos){
		//implement
		if(s.isEmpty() || pos < 0 || pos >= strArray.length) {
			return;
		}

		if (size == strArray.length -1) {
			resize();
		}
		int temp = size+1;
		while (temp > pos) {
			strArray[temp] = strArray[temp-1];
			temp--;
		}
		strArray[pos] = s;
		size++;
	}
	
	public boolean remove(String s){
		//implement
		if(s.isEmpty()) {
			return false;
		}
		for (int i = 0; i < size; i++) {
			if(strArray[i].equals(s)) {
				int temp = i;
				while (temp < size) {
					strArray[temp] = strArray[temp+1];
					temp++;
				}
				size--;
				return true;
			}
		}
		return false;
	}
	
	
	private void resize(){
		//implement
		System.out.println("Resizing...");
		String[] temp = new String[strArray.length * 2];
		System.arraycopy(strArray,0, temp, 0, strArray.length);
		strArray = temp;
	}
	public String toString(){
		//implement
		String res = "[";
		for (int i = 0; i < size; i++) {
			if(i == size-1) {
				res += strArray[i] + "]";
			} else {
				res += strArray[i] + ", ";
			}
		}
		return res;
	}
	public int size() {
		return size;
	}

	public static void main(String[] args){
		MyStringList l = new MyStringList();
		l.add("Bob");
		System.out.println("The list of size "+l.size()+" is "+l);
		l.add("Steve");
		System.out.println("The list of size "+l.size()+" is "+l);
		l.add("Susan");
		System.out.println("The list of size "+l.size()+" is "+l);
		l.add("Mark");
		System.out.println("The list of size "+l.size()+" is "+l);
		l.add("Dave");
		System.out.println("The list of size "+l.size()+" is "+l);
		l.remove("Mark");
		System.out.println("The list of size "+l.size()+" is "+l);
		l.remove("Bob");
		System.out.println("The list of size "+l.size()+" is "+l);
		l.insert("Richard",3);
		System.out.println("The list of size "+l.size()+" after inserting Richard into pos 3 is "+l);
		l.insert("Tonya",0);
		System.out.println("The list of size "+l.size()+" after inserting Tonya into pos 0 is "+l);		
	}

}
