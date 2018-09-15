package com.falabella.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

  private static PropertyManager instance;
  private static final Object lock = new Object();
  private static String propertyFilePath =
      System.getProperty("user.dir") + "/src/test/resources/environment.properties";
  private static String url;
  
  private static String propertyFilePath2 =
      System.getProperty("user.dir") + "/src/test/resources/selenoid.properties";
  private static String selenoid;
  private static String port;

  // Create a Singleton instance. We need only one instance of Property Manager.
  public static PropertyManager getInstance() {
    if (instance == null) {
      synchronized (lock) {
        instance = new PropertyManager();
        instance.loadData();
      }
    }
    return instance;
  }

  // Get all configuration data and assign to related fields.
  private void loadData() {
    // Declare a properties object
    Properties prop = new Properties();

    // Read configuration.properties file
    try {
      // prop.load(this.getClass().getClassLoader().getResourceAsStream("environment.properties"));
      prop.load(new FileInputStream(propertyFilePath));
    } catch (IOException e) {
      System.out.println("Configuration properties file cannot be found propertyFilePath");
    }
    
    try {
      // prop.load(this.getClass().getClassLoader().getResourceAsStream("selenoid.properties"));
      prop.load(new FileInputStream(propertyFilePath2));
    } catch (IOException e) {
      System.out.println("Configuration properties file cannot be found propertyFilePath");
    }

    // Get properties from configuration.properties
    url = prop.getProperty("url");
    // Get properties from configuration.properties
    selenoid = prop.getProperty("selenoid");
    port = prop.getProperty("port");
  }

  public String getURL() {
    return url;
  }
  public String getSelenoid() {
    return selenoid;
  }
  public String getPort() {
    return port;
  }
}
