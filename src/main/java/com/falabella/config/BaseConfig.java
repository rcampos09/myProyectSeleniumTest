package com.falabella.config;

import java.net.MalformedURLException;
import java.net.URI;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(com.falabella.config.Listener.class)

public class BaseConfig {

  public RemoteWebDriver driver;

  String urlPage = PropertyManager.getInstance().getURL();
  String urlSelenoid = PropertyManager.getInstance().getSelenoid();
  String portSelenoid = PropertyManager.getInstance().getPort();
  String versionBrowser = PropertyManager.getInstance().getBrowser();

  @BeforeMethod
  public RemoteWebDriver getDriver() throws Exception {
    if (driver == null) {

      DesiredCapabilities browser = new DesiredCapabilities();
      
      browser.setBrowserName(System.getProperty("dlx.browser"));
      browser.setVersion(versionBrowser);
      browser.setCapability("enableVNC", true);
      try {
        driver = new RemoteWebDriver(URI.create(urlSelenoid + portSelenoid).toURL(), browser);
        driver.manage().window().maximize();
        driver.get(urlPage);
      } catch (MalformedURLException e) {
        System.out.println("error " + e.getMessage());
        e.printStackTrace();
      }
    }
    return driver;
  }

  @AfterMethod
  public void closeDriver() {
    driver.quit();
  }
}
