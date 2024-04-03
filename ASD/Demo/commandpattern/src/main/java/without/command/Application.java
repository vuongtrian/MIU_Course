package without.command;

public class Application {

	public static void main(String[] args) {
		Stack stack = new Stack();
	    stack.push(new Integer(6));
	    System.out.println(stack);
	    
	    stack.push(new Integer(3));
	    System.out.println(stack);
	    
	    stack.pop();
	    System.out.println(stack);
	}
}
