package lazy;

public class CustomerDAO {
	Connection conn;

	public CustomerDAO() {
		conn = ConnectionPool.getPool().getConnection();
	}

	public void save() {
		conn.open();
	}
}
