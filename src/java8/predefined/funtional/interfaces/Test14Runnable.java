package java8.predefined.funtional.interfaces;

// Lambda expression with threads
public class Test14Runnable {

    public static void main(String[] args) {
        // Runnable is a functional interface with run() method, so we can use Lambda
        Runnable runnable = () -> {
            for (int i =0; i<10; i++) {
                System.out.println("Child Thread");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        for (int i=0; i<10; i++) {
            System.out.println("Main Thread");
        }
    }

}
