package java8.predefined.funtional.interfaces;

import java.util.ArrayList;
import java.util.function.Predicate;

class Employee {
    String name;
    Integer salary;

    Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class Test3PredicateEmployee {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Surya", 1000));
        employees.add(new Employee("Durga", 2000));
        employees.add(new Employee("Ravi", 3000));
        employees.add(new Employee("Shiva", 4000));
        employees.add(new Employee("Mahesh", 5000));
        employees.add(new Employee("Adarsh", 6000));

        // Check who are the employees salary greater than 3000
        Predicate<Employee> employeePredicate = employee -> employee.salary > 3000;
        for (Employee employee : employees) {
            if (employeePredicate.test(employee)) {
                System.out.println("EmployeeName"+ employee.name);
            }
        }
    }
}
