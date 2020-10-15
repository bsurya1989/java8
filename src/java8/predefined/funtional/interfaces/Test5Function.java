package java8.predefined.funtional.interfaces;

/* Take some input and perform some conditional check and returns boolean value then use PREDICATE */
/* Take some input and perform some operation and return the result which is need not be boolean type then use FUNCTION */
/* Accept some input and perform required operation and not required to return anything then use CONSUMER */

//Function
/* When you preform some operation and product result then use Function
   Function
   i->i*i
   s->s.length()
We read some input perform some operation on the input and provide the result, the result need not be boolean than we can go for Functions
*/

import java.util.function.Function;

public class Test5Function {
    public static void main(String[] args) {
        // Eg: Function<InputType, ReturnType>
        Function<Integer,Integer> function = integer -> integer * integer;
        System.out.println(function.apply(4));
        System.out.println(function.apply(5));

        Function<String, Integer> function1 = string -> string.length();
        System.out.println(function1.apply("Surya"));
        System.out.println(function1.apply("Nandini"));

        Function<String, String> function2 = string -> string.toUpperCase();
        System.out.println(function2.apply("Surya"));


        // Apply function joining
        Function<Integer, Integer> function3 = integer -> integer * integer;
        Function<Integer, Integer> function4 = integer -> 2 * integer;
        System.out.println(function3.andThen(function4).andThen(function4).apply(4));

        Function<Integer, Integer> function5 = function3.andThen(function4);
        System.out.println(function5.apply(8));
    }
}
