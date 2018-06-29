package utils;

import java.util.Properties;

/**
 * SettingsHelper is used to get login and password from properties file
 */
public class SettingsHelper {

    private static final Properties settings;

    static {
        settings = PropertiesUtils.getProperties("/settings.properties");
    }

    public static String getLogin() {
        return settings.getProperty("login");
    }

    public static String getPass() {
        return settings.getProperty("pass");
    }

    public static String getHost() {
        return settings.getProperty("host");
    }

    public static String getPort() {
        return settings.getProperty("port");
    }

    public static String getProtocol() {
        return settings.getProperty("protocol");
    }

    public static String getFolder() {
        return settings.getProperty("folder");
    }
}
