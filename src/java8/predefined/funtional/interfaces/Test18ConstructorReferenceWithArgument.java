package java8.predefined.funtional.interfaces;

class Sample1 {
    public Sample1() { // The input arguments must match
        System.out.println("Sample class constructor executed without argument ");
    }

    public Sample1(String s) { // The input arguments must match
        System.out.println("Sample class constructor executed with argument " + s);
    }
}

interface Interf4 {
    public Sample1 get(String s); // The input arguments must match
}

public class Test18ConstructorReferenceWithArgument {

    public static void main(String[] args) {
        Interf4 interf4 = Sample1::new;
        Sample1 sample = interf4.get("Surya");
        // Sample1 sample1 = interf4.get();   // This will not work because interface has only one method so it will always going to call constructor with arguments in this case
    }
}
