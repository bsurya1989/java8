package java8.summary;

interface Interf {
    int square(int n);
}

public class Test1FunctionalInterface {
    public static void main(String[] args) {
        Interf interf = n -> n*n;
        System.out.println(interf.square(5));
    }
}
