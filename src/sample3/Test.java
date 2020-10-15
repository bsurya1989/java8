package sample3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String args[]) {
        Test test = new Test();
        Calendar cal = Calendar.getInstance();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String stringDate = sdf.format(cal.getTime());

        System.out.println(stringDate);
        System.out.println(test.checkIfInStaffBranchList("067388"));

        String stringDate1 = sdf.format(cal.getTime());
        System.out.println(stringDate1);
    }

    private boolean checkIfInStaffBranchList(String staffBranch) {
        String STAFF_BRANCH_LIST = "06738,06739,06740,06741,06742,06743,06744,06745,06746,06747,06748,06749,06750,06751,06752,06753,06754,06755,06756,06757,06758,06759,06760,06761,06762,06763,06764,06765,06766,06767,06768,06769,06770,06771,06772,06773,06774,06775,06776,06777,06778,06779,06780,06781,06782,06783,06784,06785,06786,06787,06788,06789,06790,06791,06792,06793,06794,06795,06796,06797,06798,06799,06800,06801,06802,06803,06804,06805,06806,06807,06808,06809,06810,06811,06812,06813,06814,06815,06816,06817,06818,06819,06820,06821,06822,06823,06824,06825,06826,06827,06828,06829,06830,06831,06832,06833,06834,06835,06836,06837,06838,06839,06840,06841,06842,06843,06844,06845,06846,06847,06848,06849,06850,06851,06852,06853,06854,06855,06856,06857,06858,06859,06860,06861,06862,06863,06864,06865,06866";

        String[] staffBranchList = STAFF_BRANCH_LIST.split(",");
        List<String> list = Arrays.asList(staffBranchList);
        if (list.contains(staffBranch)) {
            return true;
        } else {
            return false;
        }

    }



}
