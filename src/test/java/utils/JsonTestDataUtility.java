package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonTestDataUtility {

    public JsonNode readJsonFile(String resourcePath)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream =
                getClass()
                        .getClassLoader()
                        .getResourceAsStream(resourcePath);

        if (inputStream == null) {
            throw new IOException(
                    "Test data file not found: " + resourcePath
            );
        }

        return objectMapper.readTree(inputStream);
    }
}