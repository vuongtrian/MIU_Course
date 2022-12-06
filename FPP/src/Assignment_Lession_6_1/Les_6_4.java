package Assignment_Lession_6_1;

public class Les_6_4 {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Steve", "IT", 1000, "Employee");
        System.out.println("Employee salary: " + employee.addBonus());

        Manager manager = new Manager(2, "Jack", "Business", 2000, "Manager");
        System.out.println("Mamager salary: " + manager.addBonus());

        Clerk clerk = new Clerk(3, "Tom", "Business", 500, "Clerk");
        System.out.println("Clerk salary: " + clerk.addBonus());
    }
}

class Employee {
    int id;
    String name;
    String department;
    int salary;
    String designation;
    int bonus = 200;



    public Employee(int id, String name, String department, int salary, String designation) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.designation = designation;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // This method will calculate salary of Employee including default bonus $200
    // If salary is 1000, salary will be $1200
    public int addBonus () {
        return salary + bonus;
    }
}

class Manager extends Employee{
    int bonus = 300;

    public Manager(int id, String name, String department, int salary, String designation) {
        super(id, name, department, salary, designation);
    }

    // This method will calculate salary of Manager including bonus $300
    // If salary is 1000, salary will be $1300
    @Override
    public int addBonus() {
        return super.salary + this.bonus;
    }
}

class Clerk extends Employee{
    int bonus = 100;

    public Clerk(int id, String name, String department, int salary, String designation) {
        super(id, name, department, salary, designation);
    }

    // This method will calculate salary of Clerk including bonus $100
    // If salary is 1000, salary will be $1100
    @Override
    public int addBonus() {
        return super.salary + this.bonus;
    }
}
