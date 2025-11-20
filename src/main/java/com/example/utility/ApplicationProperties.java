package com.example.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {
    private static ApplicationProperties instance = null;
    private Properties props = null;

    private ApplicationProperties() {
        try {
            props = new Properties();
            // 1. Load properties from classpath
            props = new Properties();
            InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
            props.load(in);
            // 2. Resolve ${var} inside values
            for (String key : props.stringPropertyNames()) {
                String value = props.getProperty(key);

                if (value.contains("${")) {
                    for (String innerKey : props.stringPropertyNames()) {
                        value = value.replace("${" + innerKey + "}", props.getProperty(innerKey));
                    }
                    props.setProperty(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ApplicationProperties getInstance() {
        if (instance == null) {
            instance = new ApplicationProperties();
        }
        return instance;
    }

    public Properties getProps() {
        return props;
    }
}
