package com.absli.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	Properties prop = new Properties();
    String projectPath = System.getProperty("user.dir");

    public String getProperties(String name) throws IOException {
        InputStream input = new FileInputStream(projectPath + "/src/main/java/com/absli/config/config.properties");
        prop.load(input);
        return prop.getProperty(name);
    }

    public void setProperties(String propValue, String name) throws IOException {
        OutputStream out = new FileOutputStream(projectPath + "/src/main/java/com/absli/config/config.properties");
        prop.setProperty(propValue,name);
        //prop.store(out);
    }


}
