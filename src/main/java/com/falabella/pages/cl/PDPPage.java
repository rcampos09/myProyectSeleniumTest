package com.falabella.pages.cl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.seleniumTest.BaseConfig;

public class PDPPage extends BaseConfig {

  public PDPPage(RemoteWebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//div[@class='fb-product__form']")
  public WebElement pdpProduct_Div;

  public boolean valid_PDP_Product() {
    try {
      return pdpProduct_Div.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }
}
