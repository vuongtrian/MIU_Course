package eager;

public class ConnectionPool {
	  private static ConnectionPool pool = new ConnectionPool();
	  //this is a pool with only 1 connection
	  private Connection connection = new Connection();

	  private ConnectionPool() {}

	  public static ConnectionPool getPool() {
	    return pool;
	  }
	  public Connection getConnection(){
	    return connection;
	  }
	}

