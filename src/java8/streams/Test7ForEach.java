package java8.streams;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Test7ForEach {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Surya");
        names.add("Prakash");
        names.add("Bhadragiri");

        names.stream().forEach(s -> {
            System.out.println(s);
        });

        System.out.println("Printing values using Method reference");
        names.stream().forEach(System.out::println);
    }
}
