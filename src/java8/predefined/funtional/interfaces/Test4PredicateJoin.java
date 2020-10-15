package java8.predefined.funtional.interfaces;

// Predicate Joining
// Two predicates --> This concept is called Predicate joining
// Predicate1 --> to check whether the number is even or not
// Predicate2 --> to check whether the number > 10 or not

// p1.and(p2).test(34)
// p1.or(p2).test(51)

import java.util.function.Predicate;

public class Test4PredicateJoin {
    public static void main(String[] args) {
        int[] nums = {0, 5, 10, 15, 20, 25, 30, 35};

        Predicate<Integer> p1 = integer -> integer%2==0;
        Predicate<Integer> p2 = integer -> integer>10;

        System.out.println("The numbers which are even and greater 10 are:");
        for (int number : nums) {
            if (p1.and(p2).test(number)) {
                System.out.println(number);
            }
        }

        System.out.println("The numbers which are even or greater 10 are:");
        for (int number : nums) {
            if (p1.or(p2).test(number)) {
                System.out.println(number);
            }
        }

        System.out.println("The numbers which are NOT even:");
        for (int number : nums) {
            if (p1.negate().test(number)) {
                System.out.println(number);
            }
        }
    }
}
