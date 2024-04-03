package counter;

public class Counter extends Subject{
	
	private int count=0;
	private CountState countState;

	public CountState getCountState() {
		return countState;
	}

	public void setCountState(CountState countState) {
		this.countState = countState;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void increment(){
//		count++;
		countState.add();
		System.out.println("count = " + countState.counter.getCount());
    	donotify(count);
	}
	
	public void decrement(){
//		count--;
		countState.subtract();
		System.out.println("count = " + countState.counter.getCount());
    	donotify(count);
	}

}
