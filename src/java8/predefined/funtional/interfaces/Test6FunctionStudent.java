package java8.predefined.funtional.interfaces;

// Write a function to find grade of the student based on below
// Marks >= 80 then Grade A
// Marks >=60 then Grade B
// Marks >=50 then Grade C
// Marks >=35 then Grade D
// else then Grade F

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class Test6FunctionStudent {
    public static void main(String[] args) {

        Function<Student, String> function = student -> {
            if (student.marks >= 80) return "Grade A";
            if (student.marks >= 60) return "Grade B";
            if (student.marks >= 50) return "Grade C";
            if (student.marks >= 35) return "Grade D";
            else return "Grade F (Failed)";
        };

        Predicate<Student> predicate = student -> student.marks > 35;
        Consumer<Student> studentConsumer = student -> {
            System.out.print(student.name + " with " + student.marks + " marks");
        };

        Student[] students = {new Student("Ajay", 91),
                new Student("Rama", 65),
                new Student("Lucky", 30),};

        for (Student s : students) {
            // Check whether the student marks is greater than 35
            if (predicate.test(s)) {
                studentConsumer.accept(s);
                System.out.print(" obtains " + function.apply(s));
                System.out.println();
            }
        }
    }
}
