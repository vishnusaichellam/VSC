package tests;

import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.Test;
import utils.JsonTestDataUtility;

public class JsonTestDataUtilityTest {

    @Test
    public void readLoginData() throws Exception {

        JsonTestDataUtility jsonUtility =
                new JsonTestDataUtility();

        JsonNode loginData =
                jsonUtility.readJsonFile(
                        "testdata/loginData.json"
                );

        for (JsonNode user : loginData) {

            String username =
                    user.get("username").asText();

            String password =
                    user.get("password").asText();

            System.out.println(
                    "Username: " + username
                            + " | Password: " + password
            );
        }
    }
}