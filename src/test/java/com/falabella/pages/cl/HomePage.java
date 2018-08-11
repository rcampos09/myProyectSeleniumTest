package com.falabella.pages.cl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.seleniumTest.BaseConfig;

public class HomePage extends BaseConfig {

  public HomePage(RemoteWebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  @FindBy(name = "Ntt")
  public WebElement searh_Inpt;

  public void SearhSku(String sku) {
    searh_Inpt.sendKeys(sku);
    searh_Inpt.submit();
  }
}
