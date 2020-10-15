package sample1;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ParseStringToInt {

    public static void main(String[] args) throws Exception {
        /*String num1 = "10611012 ";
        System.out.println("Num1" + num1);
        System.out.println(Integer.parseInt(num1));*/

        /*String sDate1="1998-12-10 18:00:00";
        Date date1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(sDate1);
        System.out.println(sDate1+"\t"+date1);
        Timestamp ts=new Timestamp(date1.getTime());
        System.out.print(ts);*/

        String sDate1="2020-02-13 18:07:30";
        Date date1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(sDate1);
        Date date2 = new Date();
        System.out.println(sDate1+"\t"+date1);
        long diff = date2.getTime() - date1.getTime();
        System.out.println("diff:: "+diff/1000%60);
//        Timestamp ts=new Timestamp(date1.getTime());

        String s = "SELECT CASE_ID, PROCESS_BPDID, REQUEST_DT, TIMESTAMPDIFF(16, CHAR(SYSDATE - REQUEST_DT)) AS NUM_DAYS " +
                "FROM BPMF.ARCH_CTL WHERE ARCHIVE_DT IS NULL " +
                "AND TIMESTAMPDIFF(16, CHAR(SYSDATE - REQUEST_DT)) BETWEEN 10 AND 20 " +
                "ORDER BY REQUEST_DT DESC " +
                "WITH UR ";

    }

}
