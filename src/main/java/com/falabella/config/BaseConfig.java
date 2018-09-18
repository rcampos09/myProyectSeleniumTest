package com.falabella.config;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseConfig {

  public RemoteWebDriver driver;

  String urlPage = PropertyManager.getInstance().getURL();
  String urlSelenoid = PropertyManager.getInstance().getSelenoid();
  String portSelenoid = PropertyManager.getInstance().getPort();

  @BeforeMethod
  public RemoteWebDriver getDriver() throws Exception {
    if (driver == null) {
      DesiredCapabilities browser = new DesiredCapabilities();
      browser.setBrowserName("chrome");
      browser.setVersion("66.0");
      browser.setCapability("enableVNC", true);
      try {
        driver = new RemoteWebDriver(URI.create(urlSelenoid + portSelenoid).toURL(), browser);
        driver.manage().window().fullscreen();
        driver.get(urlPage);
      } catch (MalformedURLException e) {
        System.out.println("error " + e.getMessage());
        e.printStackTrace();
      }
    }
    return driver;
  }
  
  @AfterMethod
  public void closeDriver(ITestResult result) {
    if (ITestResult.FAILURE == result.getStatus()) {
      try {
        // Create reference of TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        // Call method to capture screenshot
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));
        System.out.println("Screenshot taken");
      } catch (Exception e) {
        System.out.println("Exception while taking screenshot " + e.getMessage());
      }
    }
    if (ITestResult.SUCCESS == result.getStatus()) {
      try {
        // Create reference of TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        // Call method to capture screenshot
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));
        System.out.println("Screenshot taken");
      } catch (Exception e) {
        System.out.println("Exception while taking screenshot " + e.getMessage());
      }
    }
    if (ITestResult.SKIP == result.getStatus()) {
      try {
        // Create reference of TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        // Call method to capture screenshot
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));
        System.out.println("Screenshot taken");
      } catch (Exception e) {
        System.out.println("Exception while taking screenshot " + e.getMessage());
      }
    }
    driver.quit();
  }
}
