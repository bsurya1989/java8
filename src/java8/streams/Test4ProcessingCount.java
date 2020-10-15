package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test4ProcessingCount {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(25);
        numbers.add(30);
        numbers.add(45);
        numbers.add(50);

        // count() method used
        long count = numbers.stream().filter(integer -> integer % 2 ==0).count();
        System.out.println("Count " + count);
    }
}
