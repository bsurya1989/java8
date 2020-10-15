package java8.predefined.funtional.interfaces;

class Sample {
    public Sample() { // The input arguments must match
        System.out.println("Sample class constructor executed");
    }
}

interface Interf3 {
    public Sample get(); // The input arguments must match
}

public class Test17ConstructorReference {

    public static void main(String[] args) {
        Interf3 interf3 = Sample::new;

        // Interface get method refers Sample class constructor
        Sample sample = interf3.get(); // Sample object got created
        Sample sample1 = interf3.get(); // Sample object got created
        Sample sample2 = interf3.get();
        Sample sample3 = interf3.get();
    }
}


