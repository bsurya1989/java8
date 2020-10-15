package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;

public class Test8ToArray {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(25);
        numbers.add(30);
        numbers.add(45);
        numbers.add(50);

        Integer[] arrayCopy = numbers.stream().toArray(Integer[]::new);
        Arrays.stream(arrayCopy).forEach(integer -> System.out.println(integer));
    }
}
