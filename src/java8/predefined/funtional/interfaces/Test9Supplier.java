package java8.predefined.funtional.interfaces;

/* SUPPLIER - Just supply my required objects and it won't take any input*/
/*
    interface Supplier<R> {
        public R get();
    }
*/

import java.util.Date;
import java.util.function.Supplier;

public class Test9Supplier {

    public static void main(String[] args) {
        Supplier<Date> supplier = () -> new Date();
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }
}
