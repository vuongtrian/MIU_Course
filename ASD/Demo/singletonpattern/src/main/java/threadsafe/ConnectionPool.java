package threadsafe;

public class ConnectionPool {
	private static ConnectionPool pool;
	// this is a pool with only 1 connection
	private Connection connection = new Connection();

	private ConnectionPool() {
		// Prevent form the reflection api.
		if (pool != null) {
			throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
		}
	}

	public static synchronized ConnectionPool getPool() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}

	public Connection getConnection() {
		return connection;
	}
}
