package java8.predefined.funtional.interfaces;

/*Normal Predicate can take only one input argument and perform some conditional check.
* Sometimes our programming requirement is we have to take two input arguments and perform  some conditional check, for this requirement
*  we should go for BiPredicate
*
* BiPredicate is exactly same as predicate except that it will take two input arguments
*
* interface BiPredicate<T1,T2>
    {
        public boolean test(T1 t1, T2 t2);
        //remaining default methods: .and(), . or(), .negate()
    }

**/

import java.util.function.BiPredicate;


// Example: To check the sum of two numbers sum is even or not
public class Test10BiPredicate {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> integerBiPredicate = (a,b) -> (a + b) % 2 == 0;

        System.out.println(integerBiPredicate.test(10,20));
        System.out.println(integerBiPredicate.test(15,20));
    }
}
