package Lab_3_1;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("An",
                "Andy",
                100.5,
                2020,8,15);

        Account accountChecking = new Account(employee, AccountType.checking, 300);
        System.out.println(accountChecking.toString());
        Account accountSaving = new Account(employee, AccountType.savings, 300);
        System.out.println(accountSaving.toString());
        Account accountRetirement = new Account(employee, AccountType.retirement, 300);
        System.out.println(accountRetirement.toString());
    }
}
