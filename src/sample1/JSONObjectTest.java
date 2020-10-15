package sample1;

/*import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;*/

public class JSONObjectTest {

    /*public static void main(String[] args) {
        String content = "{\n" +
                "    \"actionToPerform\": \"Complete\",\n" +
                "    \"outputData\": {\n" +
                "        \"workItemCompletedByCustomer\": \"600000336984\",\n" +
                "        \"workItemCompletedByStaffMember\": null,\n" +
                "        \"generatedByIntent\": \"ActivateProductsGatherProductDetails\",\n" +
                "        \"caseId\": 10000000047\n" +
                "    }\n" +
                "}";

        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        try {
            json = (JSONObject) parser.parse(content);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String actionToPerform = (String) json.get("actionToPerform");
        System.out.println("ActionToPerform : " + actionToPerform);

        JSONObject outputData = (JSONObject) json.get("outputData");
        String requestingECN = (String) outputData.get("workItemCompletedByCustomer");
        System.out.println(requestingECN);
    }*/
}
