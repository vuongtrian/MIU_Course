package miu.edu;

import java.util.ArrayList;
import java.util.Collection;

public class HistoryList {
	private Collection<Command> commandlist = new ArrayList<Command>();
	public void addCommand(Command commandObject) {
		commandlist.add(commandObject);
	}
}
