package java8.predefined.funtional.interfaces;

/*
* interface BiFunction<T,U,R>
    {
        public R test(T t, U u);
        //remaining default methods: .andThen()
    }
*
* */

import java.util.ArrayList;
import java.util.function.BiFunction;

class Employee1 {
    int eno;
    String name;

    public Employee1(int eno, String name) {
        this.eno = eno;
        this.name = name;
    }
}

public class Test11BiFunction {
    public static void main(String[] args) {
        BiFunction<Integer, String, Employee1> biFunction = (empNo, empName) -> new Employee1(empNo, empName);

        ArrayList<Employee1> arrayList = new ArrayList<>();
        arrayList.add(biFunction.apply(1, "Surya"));
        arrayList.add(biFunction.apply(2, "Prakash"));
        arrayList.add(biFunction.apply(3, "Bhadragiri"));

        for (Employee1 emp : arrayList) {
            System.out.println(emp.eno + " = " + emp.name);
        }
    }
}
