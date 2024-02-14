package decorator;

import java.io.IOException;
import java.util.Properties;

public class Config {
    
    private final static String config = "/resources/config.properties";
    private static Properties properties = new Properties();

    // Load properties
    private static void loadProperties() {

        // Load properties
        try {
            properties.load(Config.class.getResourceAsStream(config));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get property
    public static String getProperty(String key) {
        loadProperties();
        return properties.getProperty(key);
    }
}
