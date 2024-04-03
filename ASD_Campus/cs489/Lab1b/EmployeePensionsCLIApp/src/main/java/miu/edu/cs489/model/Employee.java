package miu.edu.cs489.model;

import java.time.LocalDate;

public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private Double yearlySalary;
    private PensionPlan pensionPlan;

    public Employee() {
    }

    public Employee(Long employeeId, String firstName, String lastName, LocalDate employmentDate, Double yearlySalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
    }

    public Employee(Long employeeId, String firstName, String lastName, LocalDate employmentDate, Double yearlySalary, PensionPlan pensionPlan) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = pensionPlan;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(Double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }

    @Override
    public String toString() {
        if(pensionPlan == null) {
            return
                    "\"employeeId\":" + employeeId +
                            ", \"firstName\":'" + firstName + '\'' +
                            ", \"lastName\":'" + lastName + '\'' +
                            ", \"employmentDate\":" + employmentDate +
                            ", \"yearlySalary\":" + yearlySalary;
        } else {
            return
                    "\"employeeId\":" + employeeId +
                    ", \"firstName\":'" + firstName + '\'' +
                    ", \"lastName\":'" + lastName + '\'' +
                    ", \"employmentDate\":" + employmentDate +
                    ", \"yearlySalary\":" + yearlySalary +
                    ", \"pensionPlan\":" + pensionPlan;
        }


    }
}
