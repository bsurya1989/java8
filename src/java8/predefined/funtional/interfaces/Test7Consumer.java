package java8.predefined.funtional.interfaces;

import java.util.function.Consumer;

/* PREDICATE : Take some input and perform some conditional check and returns boolean value then use */
/* FUNCTION : Take some input and perform some operation and return the result which is need not be boolean type then use */
/* CONSUMER : Accept some input and perform required operation and not required to return anything then use */

public class Test7Consumer {

    public static void main(String[] args) {
        Consumer<String> stringConsumer = (s) -> {
            System.out.println(s);
        };

        stringConsumer.accept("This is Surya");
    }
}
