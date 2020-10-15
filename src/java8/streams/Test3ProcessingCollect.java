package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test3ProcessingCollect {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(25);
        numbers.add(30);
        numbers.add(45);
        numbers.add(50);

        List<Integer> filteredList = numbers.stream().filter(integer -> integer % 2 ==0).collect(Collectors.toList());

        filteredList.forEach((integer) -> {
            System.out.println(integer);
        });


        // Filter all the names whose length is greater than 5 characters and put them in a new list
        ArrayList<String> names = new ArrayList<>();
        names.add("Surya");
        names.add("Prakash");
        names.add("Bhadragiri");

        // collect() method is used after filtering
        List<String> namesFiltered = names.stream().filter(s -> s.length()>5).collect(Collectors.toList());

        System.out.println();
        namesFiltered.forEach(s -> {
            System.out.println(s);
        });

        System.out.println();
        // collect() method with map method
        List<String> namesFiltered1 = names.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());

        namesFiltered1.forEach(s -> {
            System.out.println(s);
        });
    }
}
