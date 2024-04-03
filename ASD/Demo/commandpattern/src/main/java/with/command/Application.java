package with.command;

public class Application {

	public static void main(String[] args) {
		Stack stack = new Stack();
		HistoryList hlist = new HistoryList();
		PushCommand pushc1 = new PushCommand(stack, new Integer(6));
		pushc1.execute();
		hlist.addCommand(pushc1);
		System.out.println(stack);

		PushCommand pushc2 = new PushCommand(stack, new Integer(3));
		pushc2.execute();
		hlist.addCommand(pushc2);
		System.out.println(stack);

		PopCommand popc1 = new PopCommand(stack);
		popc1.execute();
		hlist.addCommand(popc1);
		System.out.println(stack);

		hlist.undo();
		System.out.println(stack);
	}
}
