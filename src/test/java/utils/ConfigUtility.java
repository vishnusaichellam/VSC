package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtility {

    private Properties properties;

    public ConfigUtility() {

        properties = new Properties();

        // Read environment from system property
        String environment =
                System.getProperty("environment", "qa");

        String configFile =
                "config/config-" + environment + ".properties";

        try (InputStream inputStream =
                     getClass()
                             .getClassLoader()
                             .getResourceAsStream(configFile)) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "Configuration file not found: "
                                + configFile
                );
            }

            properties.load(inputStream);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to load configuration file: "
                            + configFile,
                    e
            );
        }
    }

    public String getProperty(String key) {

        String value =
                properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException(
                    "Configuration property not found: "
                            + key
            );
        }

        return value;
    }
}