package java8.summary;

interface Interf2 {
    int sum(int a, int b);


}

public class Test2DefaultMethod implements Interf2 {

    @Override
    public int sum(int a, int b) {
        return 0;
    }
}
