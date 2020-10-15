package sample1;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        Map<String, String> loanRepayments = new HashMap<String, String>();
        loanRepayments.put("1014", "0");
        loanRepayments.put("1014", "2");

        System.out.println(loanRepayments.get("1014"));
    }


}
