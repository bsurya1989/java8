package java8.predefined.funtional.interfaces;

import java.util.function.Predicate;

/* Take some input and perform some conditional check and returns boolean value then use PREDICATE -- test() */
/* Take some input and perform some operation and return the result which is need not be boolean type then use FUNCTION -- apply() */
/* Accept some input and perform required operation and not required to return anything then use CONSUMER -- accept() */
/* Just supply my required objects and it won't take any input SUPPLIER -- get() */

public class Test1Predicate {

    public static void main(String args[]) {

        Predicate<Integer> predicateInteger = integer -> integer%2==0;
        System.out.println("Number 10 is even or not: " +predicateInteger.test(10));
        System.out.println("Number 15 is even or not: " +predicateInteger.test(15));

        System.out.println("Print names whose length is greater than 6 characters");
        String s[] = {"Surya", "Prakash", "Bhadragiri", "Nandini", "Vadlamuri"};
        Predicate<String> predicate = s1 -> s1.length() > 6;

        for (String name: s) {
            if(predicate.test(name)) {
                System.out.println(name);
            }
        }

    }
}
