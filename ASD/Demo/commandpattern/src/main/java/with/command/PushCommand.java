package with.command;

public class PushCommand implements Command{
	  Stack stack;
	  Integer i;


	  public PushCommand(Stack stack, Integer i) {
	    this.stack = stack;
	    this.i=i;
	  }

	  public void execute(){
	    stack.push(i);
	  }
	  
	  public void unExecute(){
	    stack.pop();
	  }
}
