package java8.streams;

/* A Filter is used to create filtering on the collection based on age, salary etc */
/* A Map is used to do some operation on each collection object and create new set of collection */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test2Map {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(25);
        numbers.add(30);
        numbers.add(45);
        numbers.add(50);

        List<Integer> mapList = numbers.stream().map(integer -> integer * 2).collect(Collectors.toList());

        mapList.forEach(integer -> {
            System.out.println(integer);
        });
    }
}
