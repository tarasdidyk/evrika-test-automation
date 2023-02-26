package utils;

import lombok.experimental.UtilityClass;

import java.util.ResourceBundle;

@UtilityClass
public class SystemPropertyHelper {

    private static final ResourceBundle bundle;

    static {
        bundle = ResourceBundle.getBundle("environment");
    }

    public static String getHomePageUrl() {
        return getProperty("home.page");
    }

    private static String getProperty(String property) {
        return bundle.containsKey(property)
                ? bundle.getString(property)
                : "";
    }
}