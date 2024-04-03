package with.command;

public class PopCommand implements Command{
	  Stack stack;
	  Integer i;


	  public PopCommand(Stack stack) {
	    this.stack = stack;
	  }

	  public void execute(){
		i=stack.pop();
	  }
	  
	  public void unExecute(){
	    stack.push(i);
	  }
}
