package sample3;


import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class TestJson {
    public static void main(String[] args) {
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5," +
                        "  \"owners\" : [\"John\", \"Jack\", \"Jill\"]," +
                        "  \"nestedObject\" : { \"field\" : \"value\" } }";

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);

            JsonNode brandNode = jsonNode.get("brand");
            String brand = brandNode.asText();
            System.out.println("brand = " + brand);

            JsonNode doorsNode = jsonNode.get("doors");
            int doors = doorsNode.asInt();
            System.out.println("doors = " + doors);

            JsonNode array = jsonNode.get("owners");
            JsonNode jsonNode2 = array.get(0);
            String john = jsonNode2.asText();
            System.out.println("john  = " + john);

            JsonNode child = jsonNode2.get("nestedObject");
            JsonNode nestedchild = child.get("field");
            System.out.println(nestedchild);
            /*String field = childField.asText();
            System.out.println("field = " + field);*/

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
