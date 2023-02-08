import java.util.List;

public class Commissioned extends Employee{
    private double commission;
    private double baseSalary;
    private List<Order> orders;

    public Commissioned(String empId, double commission, double baseSalary, List<Order> orders) {
        super(empId);
        this.commission = commission;
        this.baseSalary = baseSalary;
        this.orders = orders;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        double totalAmount = 0;
        for (Order o: orders) {
            totalAmount += o.getOrderAmount();
        }
        return baseSalary + totalAmount * commission;
    }
}
