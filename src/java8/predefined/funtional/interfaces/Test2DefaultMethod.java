package java8.predefined.funtional.interfaces;

interface Interf {
    public void m1();
    default void m2() {
        System.out.println("Inside default method");
    }
}

public class Test2DefaultMethod implements Interf {

    @Override
    public void m1() {

    }

    public static void main(String args[]) {
        Test2DefaultMethod test2 = new Test2DefaultMethod();
        test2.m2();
    }
}

