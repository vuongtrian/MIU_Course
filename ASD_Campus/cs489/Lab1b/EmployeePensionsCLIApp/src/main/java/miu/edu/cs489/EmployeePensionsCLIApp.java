package miu.edu.cs489;

import miu.edu.cs489.model.Employee;
import miu.edu.cs489.model.PensionPlan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeePensionsCLIApp {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L,
                "Daniel",
                "Agar",
                LocalDate.of(2018, 01, 17), 105945.50D,
                new PensionPlan("EX1089", LocalDate.of(2023, 01, 17), 100D)));
        employees.add(new Employee(2L,
                "Benard",
                "Shaw",
                LocalDate.of(2019, 04, 03), 197750D));
        employees.add(new Employee(3L,
                "Carly",
                "Agar",
                LocalDate.of(2014, 05, 16), 842000.75D,
                new PensionPlan("SM2307", LocalDate.of(2019, 11, 04), 1555.50D)));
        employees.add(new Employee(4L,
                "Wesley",
                "Schneider",
                LocalDate.of(2019, 05, 02), 74500D));

        System.out.println("=============TASK A=============");
        printJSON(employees);
        System.out.println("=============TASK B=============");
        monthlyReport(employees);
    }

    public static void printJSON (List<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary).reversed());
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for(Employee e : employees) {
            sb.append("\t{ ").append(e.toString()).append(" },\n");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void monthlyReport (List<Employee> employees) {
        LocalDate firstDayOfNextMonth = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        LocalDate lastDayOfNextMonth = firstDayOfNextMonth.plusMonths(1).minusDays(1);
        List<Employee> qualifiedEmp = employees.stream()
                .filter(employee -> employee.getPensionPlan() == null)
                .filter(employee -> employee.getEmploymentDate().plusYears(5).isAfter(firstDayOfNextMonth) &&
                        employee.getEmploymentDate().plusYears(5).isBefore(lastDayOfNextMonth))
                .collect(Collectors.toList());
        qualifiedEmp.sort(Comparator.comparing(Employee::getEmploymentDate));
        printJSON(qualifiedEmp);
    }
}
