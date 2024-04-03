package lazy;

public class Application {

	public static void main(String[] args) {
		CustomerDAO cdao = new CustomerDAO();
		cdao.save();
		ProductDAO pdao = new ProductDAO();
		pdao.save();
	}
}