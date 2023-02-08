abstract public class Employee {
    private String empId;

    public Employee(String empId) {
        this.empId = empId;
    }

    public void print(int month, int year) {
        System.out.println("EmployeeId: " + empId);
        System.out.println(calcCompensation(month, year));
    }

    public Paycheck calcCompensation(int monthValue, int year) {
        double grossPay = calcGrossPay(monthValue, year);
        return new Paycheck(grossPay, 0.23, 0.05, 0.01, 0.03, 0.075);
    }

    abstract public double calcGrossPay(int month, int year);
}
