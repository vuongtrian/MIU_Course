package counter;

public class Counter extends Subject{
	CounterState state;
	private CountHandler countHandler;
	
	private int count=0;
	
	public void increment(){
		count=state.increment();
    	donotify(count);
		countHandler.printColor(count);
	}
	
	public void decrement(){
		count=state.decrement();
    	donotify(count);
		countHandler.printColor(count);
	}

	public void setCountHandler(CountHandler countHandler) {
		this.countHandler = countHandler;
	}

	public void setState(CounterState state) {
		this.state = state;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	

}
