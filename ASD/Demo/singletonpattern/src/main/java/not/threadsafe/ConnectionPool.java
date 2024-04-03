package not.threadsafe;

public class ConnectionPool {
	private static ConnectionPool pool;
	// this is a pool with only 1 connection
	private Connection connection = new Connection();

	private ConnectionPool() {}

	public static ConnectionPool getPool() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}

	public Connection getConnection() {
		return connection;
	}
}
