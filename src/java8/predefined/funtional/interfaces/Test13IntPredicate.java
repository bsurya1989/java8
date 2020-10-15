package java8.predefined.funtional.interfaces;

/*
*
* */

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Test13IntPredicate {
    public static void main(String args[]) {

        Predicate<Integer> predicateInteger = integer -> integer % 2 == 0;
        System.out.println("Number 10 is even or not: " + predicateInteger.test(10));
        System.out.println("Number 15 is even or not: " + predicateInteger.test(15));

        // Here in the above example there is autoboxing (int --> Integer) and AutoUnboxing (Integer --> int) is happening which
        // is going to reduce the performance of the code, so for that reason they have introduced
        // PRIMITIVE VERSION OF FUNCTIONAL INTERFACES which addresses this performance issues
        // It does not do anymore autoboxing and autounboxing
        // IntPredicate     --> always take int primitive type as input value
        // DoublePredicate  --> always take double primitive type as input value
        // LongPredicate    --> always take long primitive type as input value

        int x[] = {0, 5, 10, 15, 20, 25, 30};
        IntPredicate intPredicate = integer -> integer % 2 ==0;
        for (int i : x) {
            if (intPredicate.test(i)) {
                System.out.println(i);
            }
        }
    }
}
