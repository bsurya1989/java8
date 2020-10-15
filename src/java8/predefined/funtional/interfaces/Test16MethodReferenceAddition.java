package java8.predefined.funtional.interfaces;

@FunctionalInterface
interface Interf1 {
    void sum(int a, int b);
}

public class Test16MethodReferenceAddition {
    public static void sumStaticMethod(int a, int b) {
        System.out.println("The sum: " + (a+b));
    }

    public void sumNonStaticMethod(int a, int b) {
        System.out.println("The sum: " + (a+b));
    }

    public static void main(String[] args) {
        Interf1 interf1 = (a, b) -> System.out.println("The sum: " + (a + b));
        interf1.sum(10, 20);

        Interf1 interf2 = Test16MethodReferenceAddition::sumStaticMethod;
        interf2.sum(20, 30);

        Test16MethodReferenceAddition objectRef = new Test16MethodReferenceAddition();
        Interf1 interf3 = objectRef::sumNonStaticMethod;
        interf2.sum(30, 30);
    }

}
