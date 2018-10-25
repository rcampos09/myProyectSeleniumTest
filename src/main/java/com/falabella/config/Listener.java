package com.falabella.config;

import java.util.concurrent.TimeUnit;
import org.influxdb.dto.Point;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.qameta.allure.Attachment;

public class Listener extends BaseConfig implements ITestListener {

  private static String getTestMethodName(ITestResult iTestResult) {
    return iTestResult.getMethod().getConstructorOrMethod().getName();
  }

  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] saveScreenshotPNG(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @Attachment(value = "{0}", type = "text/plain")
  private static String saveTextLog(String message) {
    return message;
  }

  @Override
  public void onTestStart(ITestResult iTestResult) {
    System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {
    System.out
        .println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
    // Allure ScreenShotRobot and SaveTestLog
    Object testClass = iTestResult.getInstance();
    try {
      RemoteWebDriver driver = ((BaseConfig) testClass).getDriver();
      if (driver instanceof RemoteWebDriver) {
        System.out.println("Screenshot capture for test case : " + getTestMethodName(iTestResult));
        saveScreenshotPNG(driver);
      } else {
        System.out
            .println("Error Screenshot capture for test case : " + getTestMethodName(iTestResult));
      }
    } catch (Exception e) {
      System.out.println("Error saveScreenshotPNG Method");
      e.printStackTrace();
    }
    // Save a log on allure.
    saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    // Save InfluxDb
    this.sendTestMethodStatus(iTestResult, "PASS");
  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {
    System.out
        .println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
    Object testClass = iTestResult.getInstance();
    // Allure ScreenShotRobot and SaveTestLog
    try {
      RemoteWebDriver driver = ((BaseConfig) testClass).getDriver();
      if (driver instanceof RemoteWebDriver) {
        System.out.println("Screenshot capture for test case : " + getTestMethodName(iTestResult));
        saveScreenshotPNG(driver);
      } else {
        System.out
            .println("Error Screenshot capture for test case : " + getTestMethodName(iTestResult));
      }
    } catch (Exception e) {
      System.out.println("Error saveScreenshotPNG Method");
      e.printStackTrace();
    }
    // Save a log on allure.
    saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    // Save InfluxDb
    this.sendTestMethodStatus(iTestResult, "FAIL");
  }

  @Override
  public void onTestSkipped(ITestResult iTestResult) {
    System.out
        .println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
    // Save InfluxDb
    this.sendTestMethodStatus(iTestResult, "SKIPPED");
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    System.out.println(
        "Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
  }

  @Override
  public void onStart(ITestContext iTestContext) {
    System.out.println("Start Falabella Country: " + System.getProperty("dlx.country"));
    System.out.println("Start Falabella Country: " + System.getProperty("dlx.browser"));
    System.out.println("I am in onStart method " + iTestContext.getName());
  }

  @Override
  public void onFinish(ITestContext iTestContext) {
    System.out.println("I am in onFinish method " + iTestContext.getName());
    // Save InfluxDb
    this.sendTestClassStatus(iTestContext);
  }

  private void sendTestMethodStatus(ITestResult iTestResult, String status) {
    Point point = Point.measurement("testmethod")
        .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
        .tag("testclass", iTestResult.getTestClass().getName())
        .tag("name", iTestResult.getName())
        .tag("description", iTestResult.getMethod().getDescription())
        .tag("result", status)
        .tag("country",System.getProperty("dlx.country"))
        .tag("browser",System.getProperty("dlx.browser"))
        .addField("duration", (iTestResult.getEndMillis() - iTestResult.getStartMillis())).build();
    ResultSender.send(point);
  }

  private void sendTestClassStatus(ITestContext iTestContext) {
    Point point =
        Point.measurement("testclass").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
            .tag("name", iTestContext.getAllTestMethods()[0].getTestClass().getName())
            .addField("duration",
                (iTestContext.getEndDate().getTime() - iTestContext.getStartDate().getTime()))
            .build();
    ResultSender.send(point);
  }
}
