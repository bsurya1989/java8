package java8.streams;

import java.util.ArrayList;

public class Test6MinAndMax {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(45);
        numbers.add(50);
        numbers.add(25);
        numbers.add(30);

        Integer max = numbers.stream().max((o1, o2) -> o1.compareTo(o2)).get();
        System.out.println("Max value: " + max);

        Integer min = numbers.stream().min((o1, o2) -> o1.compareTo(o2)).get();
        System.out.println("Min value: " + min);
    }
}
