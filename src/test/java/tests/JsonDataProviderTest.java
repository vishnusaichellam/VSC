package utils;

import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonTestDataUtility;

public class JsonDataProviderTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() throws Exception {

        JsonTestDataUtility jsonUtility =
                new JsonTestDataUtility();

        JsonNode loginData =
                jsonUtility.readJsonFile(
                        "testdata/loginData.json"
                );

        Object[][] data =
                new Object[loginData.size()][2];

        for (int i = 0; i < loginData.size(); i++) {

            data[i][0] =
                    loginData.get(i)
                            .get("username")
                            .asText();

            data[i][1] =
                    loginData.get(i)
                            .get("password")
                            .asText();
        }

        return data;
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        System.out.println(
                "Username: " + username
                        + " | Password: " + password
        );
    }
}