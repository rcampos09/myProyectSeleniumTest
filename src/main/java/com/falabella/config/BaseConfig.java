package com.falabella.config;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IHookCallBack;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

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
  
  @Attachment(value = "Screenshot of {0}", type = "image/png")
  public byte[] saveScreenshot(String name, WebDriver driver) {
      return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
      iHookCallBack.runTestMethod(iTestResult);
      if (iTestResult.getThrowable() != null) {
          this.saveScreenshot(iTestResult.getName(), driver);
          
      }
  }

  @AfterMethod
  public void closeDriver(ITestResult result) {
    if (ITestResult.FAILURE == result.getStatus()) {
      try {
        // Create refernce of TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        // Call method to capture screenshot
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));
        this.saveScreenshot(result.getName(), driver);
        System.out.println("Screenshot taken");
        
        Allure.addAttachment("My attachment", "My attachment content");
        Path content = Paths.get("path-to-my-attachment-contnet");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("My attachment", is);
        }
      } catch (Exception e) {
        System.out.println("Exception while taking screenshot " + e.getMessage());
      }
    }
    if (ITestResult.SUCCESS == result.getStatus()) {
      try {
        // Create    of TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        // Call method to capture screenshot
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));
        this.saveScreenshot(result.getName(), driver);
        System.out.println("Screenshot taken");
        
        Allure.addAttachment("My attachment", "My attachment content");
        Path content = Paths.get("path-to-my-attachment-contnet");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("My attachment", is);
        }
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
        this.saveScreenshot(result.getName(), driver);
        System.out.println("Screenshot taken");
        
        Allure.addAttachment("My attachment", "My attachment content");
        Path content = Paths.get("path-to-my-attachment-contnet");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("My attachment", is);
        }
      } catch (Exception e) {
        System.out.println("Exception while taking screenshot " + e.getMessage());
      }
    }
    driver.quit();
  }
}
