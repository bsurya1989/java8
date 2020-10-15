package java8.predefined.funtional.interfaces;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Test12BiConsumer {

    public static void main(String[] args) {
        BiConsumer<Employee, Integer> biConsumer = (e, num) -> e.salary = e.salary + num;

        Consumer<Employee> employeeConsumer = employee -> {
            System.out.println(employee.name + " - " + employee.salary);
        };

        ArrayList<Employee> employees = new ArrayList<>();
        populate(employees);

        for (Employee e : employees) {
            biConsumer.accept(e, 500);
            employeeConsumer.accept(e);
        }
    }

    public static void populate(ArrayList<Employee> employees) {
        employees.add(new Employee("Surya", 1000));
        employees.add(new Employee("Prakash", 2000));
        employees.add(new Employee("Bhadragiri", 3000));
    }
}

