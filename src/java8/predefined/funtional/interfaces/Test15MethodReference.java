package java8.predefined.funtional.interfaces;

// Method reference will allow to make use of methods without writing it again as lambda. This allows code re-usability
// In method reference the method input type parameters should be same and does not worry about return type and modifiers.
public class Test15MethodReference {

    // Static method
    public static void m1() { // should match run()
        for (int i = 0; i < 10; i++) {
            System.out.println("Static method");
        }
    }

    // Non-static method
    public void m2() { // should match run()
        for (int i = 0; i < 10; i++) {
            System.out.println("Non Static method");
        }
    }

    public static void main(String[] args) {
        // Runnable is a functional interface with run() method, so we can use Lambda
        Runnable runnableStaticMethod = Test15MethodReference::m1;   // Method reference, which is a replacement of lambda expression
        // by using already existing method, which allows code re-usablity

        Thread thread = new Thread(runnableStaticMethod);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
        }

        Test15MethodReference test15MethodReference = new Test15MethodReference();
        Runnable runnableNonStaticMethod = test15MethodReference::m2;
        Thread thread1 = new Thread(runnableNonStaticMethod);
        thread1.start();

    }

}
