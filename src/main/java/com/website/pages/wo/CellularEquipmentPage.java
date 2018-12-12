package com.website.pages.wo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.website.config.BaseConfig;

public class CellularEquipmentPage extends BaseConfig {

  public CellularEquipmentPage(RemoteWebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//input[@id='search']")
  public WebElement searchInpt;
  
  public void search_Equipos(String phone) {
    searchInpt.sendKeys(phone);
  }
}
