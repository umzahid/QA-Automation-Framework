package com.umair.framework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Centralized config reader — loads from config.properties.
 * Allows overrides via system properties (useful for CI).
 *
 * Usage:  ConfigManager.get("browser")
 */
public class ConfigManager {

    private static final Properties props = new Properties();

    static {
        try (InputStream is = ConfigManager.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (is != null) props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        // System property overrides file value — handy for CI flags
        String sysVal = System.getProperty(key);
        return sysVal != null ? sysVal : props.getProperty(key, "");
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static int getInt(String key) {
        try { return Integer.parseInt(get(key)); }
        catch (NumberFormatException e) { return 0; }
    }
}
