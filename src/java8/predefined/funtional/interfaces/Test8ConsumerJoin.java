package java8.predefined.funtional.interfaces;

import java.util.function.Consumer;

class Movie {
    String movieName;

    public Movie(String movieName) {
        this.movieName = movieName;
    }
}

public class Test8ConsumerJoin {


    public static void main(String[] args) {
        Consumer<Movie> consumer1 = movie -> {
            System.out.println(movie.movieName + " Movie started");
        };
        Consumer<Movie> consumer2 = movie -> {
            System.out.println(movie.movieName + " Movie excellent review");
        };
        Consumer<Movie> consumer3 = movie -> {
            System.out.println(movie.movieName + " Storing data as information");
        };

        // Joining all the consumers
        Consumer<Movie> consumerJoined = consumer1.andThen(consumer2).andThen(consumer3);

        Movie m = new Movie("Jumanji");
        consumerJoined.accept(m);
    }


}
