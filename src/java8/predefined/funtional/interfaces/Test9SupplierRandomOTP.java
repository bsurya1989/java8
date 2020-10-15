package java8.predefined.funtional.interfaces;


import java.util.function.Supplier;

public class Test9SupplierRandomOTP {
    public static void main(String[] args) {
        // Supplier to generate a 6 digit OTP
        Supplier<String> s = () -> {
            String otp = "";
            for (int i = 0; i < 6; i++) {
                otp = otp+ (int) (Math.random()*10);
            }
            return otp;
        };

        System.out.println(s.get());
        System.out.println(s.get());
        System.out.println(s.get());
    }
}
