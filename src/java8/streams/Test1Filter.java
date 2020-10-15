package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* A Filter is used to create filtering on the collection based on age, salary etc */
/* A Map is used to do some operation on each collection object and create new set of collection */
public class Test1Filter {

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
    }
}
