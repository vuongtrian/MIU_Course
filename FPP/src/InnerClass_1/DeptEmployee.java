package InnerClass_1;

import java.time.LocalDate;

public class DeptEmployee {
    private String name;
    private double salary;
    private LocalDate hireDate;

    public DeptEmployee(String name, double salary, LocalDate hireDate) {
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "name=" + name + ", salary=" + salary + ", hireDate=" + hireDate;
    }
}
