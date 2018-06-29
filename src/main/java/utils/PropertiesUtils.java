package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertiesUtils class-helper to work with properties file
 */
public class PropertiesUtils {

    public static Properties getProperties(String path) {
        Properties properties = new Properties();
        try(InputStream is = PropertiesUtils.class.getResourceAsStream(path)) {
            properties.load(is);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return properties;
    }
}
