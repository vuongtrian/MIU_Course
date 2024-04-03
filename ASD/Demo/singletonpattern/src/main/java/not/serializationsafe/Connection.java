package not.serializationsafe;

import java.io.Serializable;

public class Connection implements Serializable{
	public void open() {
		System.out.println("open connection to DB");
	}
}
