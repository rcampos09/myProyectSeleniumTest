package com.seleniumTest;

import java.net.MalformedURLException;
import java.net.URI;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseConfig {

  public RemoteWebDriver driver;

  @BeforeMethod
  public RemoteWebDriver getDriver() throws Exception {
    if (driver == null) {
      DesiredCapabilities browser = new DesiredCapabilities();
      browser.setBrowserName("chrome");
      browser.setVersion("66.0");
      browser.setCapability("enableVNC", true);
      try {
        driver = new RemoteWebDriver(URI.create("http://172.17.0.2:4444/wd/hub/").toURL(), browser);
        driver.manage().window().fullscreen();
        driver.get("https://www.falabella.com/falabella-cl/");
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
