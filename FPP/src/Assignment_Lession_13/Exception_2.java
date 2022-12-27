package Assignment_Lession_13;

public class Exception_2 {
    public static void main(String[] args) {
        CustomerAccount acc = new CustomerAccount("Jack", "J123", 500);
        acc.withdraw(450);
    }
}

class  CustomerAccount {
    private String Cus_name;
    private String Acc_No;
    private double Balance;

    public CustomerAccount(String cus_name, String acc_No, double balance) {
        Cus_name = cus_name;
        Acc_No = acc_No;
        Balance = balance;
    }

    public String getCus_name() {
        return Cus_name;
    }

    public void setCus_name(String cus_name) {
        Cus_name = cus_name;
    }

    public String getAcc_No() {
        return Acc_No;
    }

    public void setAcc_No(String acc_No) {
        Acc_No = acc_No;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public boolean deposit (double amount) {
        if(amount >= 0) {
            Balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        try {
            if(amount > Balance || Balance - amount <= 100) {
                throw new WithdrawException("Balance is not enough to withdraw");
            } else {
                Balance -= amount;
                return true;
            }
        } catch (WithdrawException e) {
            System.out.println(e);
        }
        return false;
    }
}

class WithdrawException extends Exception {
    public WithdrawException (String message) {
        super(message);
    }
}