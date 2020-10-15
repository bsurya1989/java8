package sample1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDifferentExample {

    public static void main(String[] args) {

        String dateStart = "02/13/2020 20:20:00";
        String dateStop = "01/15/2012 10:31:48";

        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
//            d1 = new Date();
            d2 = new Date();
            System.out.println(d1);
            System.out.println(d2);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();
            System.out.println(timeDiff(diff));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String timeDiff(long diff) {
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);

//        System.out.print(diffDays + " days, ");
//        System.out.print(diffHours + " hours, ");
//        System.out.print(diffMinutes + " minutes, ");
//        System.out.print(diffSeconds + " seconds.");

        return diffDays + " days, "+ diffHours + " hours, "+diffMinutes + " minutes, "+diffSeconds + " seconds.";
    }
}
