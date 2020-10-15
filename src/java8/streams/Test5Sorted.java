package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test5Sorted {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(45);
        numbers.add(50);
        numbers.add(25);
        numbers.add(30);

        // Ascending order
        List<Integer> sortedDefault = numbers.stream().sorted().collect(Collectors.toList());
        sortedDefault.forEach(integer -> {
            System.out.print(integer + ", ");
        });
        System.out.println();

        System.out.println("Ascending Order");
        List<Integer> sortedAscending = numbers.stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
        sortedAscending.forEach(integer -> {
            System.out.print(integer + ", ");
        });
        System.out.println();

        System.out.println("Descending Order");// By keeping negative on the sorting for comparator will reverse the order
        List<Integer> sortedDescending = numbers.stream().sorted((o1, o2) -> -o1.compareTo(o2)).collect(Collectors.toList());
        sortedDescending.forEach(integer -> {
            System.out.print(integer + ", ");
        });
    }
}
