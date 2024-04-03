package eager;

public class ProductDAO {
	Connection conn;

	public ProductDAO() {
		conn = ConnectionPool.getPool().getConnection();
	}

	public void save() {
		conn.open();
	}
}
