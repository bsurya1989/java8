package java8.streams;

import java.util.stream.Stream;

public class Test9StreamOf {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(9, 99, 999, 9999, 99999);
        stream.forEach(System.out::println);

        Double[] doubles = {10.0, 10.2, 10.5, 10.4, 10.1};
        Stream<Double> doubleStream = Stream.of(doubles);
        doubleStream.forEach(System.out::println);
    }
}
