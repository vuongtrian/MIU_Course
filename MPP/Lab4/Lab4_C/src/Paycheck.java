final public class Paycheck {
    private double grossPay;
    private double fica;
    private double state;
    private double local;
    private double medicare;
    private double socialSecurity;

    public Paycheck(double grossPay, double fica, double state, double local, double medicare, double socialSecurity) {
        this.grossPay = grossPay;
        this.fica = fica;
        this.state = state;
        this.local = local;
        this.medicare = medicare;
        this.socialSecurity = socialSecurity;
    }

    public void print() {
        System.out.println(toString());
    }

    public double getNetPay() {
        return grossPay - (grossPay * fica)
                        - (grossPay * state)
                        - (grossPay * local)
                        - (grossPay * medicare)
                        - (grossPay * socialSecurity);
    }

    @Override
    public String toString() {
        return "Paycheck{" +
                "grossPay=" + grossPay +
                ", fica=" + fica +
                ", state=" + state +
                ", local=" + local +
                ", medicare=" + medicare +
                ", socialSecurity=" + socialSecurity +
                ", NET PAY=" + getNetPay() +
                '}';
    }
}
