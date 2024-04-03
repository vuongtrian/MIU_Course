package with.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack {
	private List<Integer> list = new ArrayList<Integer>();

	public void push(Integer num) {
		list.add(num);
	}

	public Integer pop() {
		Integer top = null;
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			top = iter.next();
		}
		iter.remove();
		return top;
	}

	@Override
	public String toString() {
		return "Stack [list=" + list + "]";
	}	
}