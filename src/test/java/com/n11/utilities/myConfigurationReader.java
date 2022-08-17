package com.n11.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class myConfigurationReader {
    private static Properties properties;

    static {

        try {
            // which file to read
            String path = "configuration.properties";
            // read the file into java, finds the file using the string path
            FileInputStream file = new FileInputStream(path);
            // properties --> class that store properties in key / value format
            properties = new Properties();
            // the values from the file input is loaded / fed in to the properties object
            properties.load(file);

            file.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {

        return properties.getProperty(keyName);
    }

}
