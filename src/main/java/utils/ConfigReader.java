package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties prop = new Properties();

    public ConfigReader() {
        try (InputStream input = new FileInputStream("src/test/resources/config/config.properties")) {
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return prop.getProperty(key);
    }
}
