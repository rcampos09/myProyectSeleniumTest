package com.website.pages.wo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.website.config.BaseConfig;

public class HomePage extends BaseConfig {

  public HomePage(RemoteWebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "(//section[@class='menu_mobile menu_mobile--active'or @class='menu_wrapper']//a[@data-union='Equipos'])[1]")
  public WebElement equipos_Btn_Link;

  public CellularEquipmentPage click_Equipos_menu() {
    equipos_Btn_Link.click();
    return new CellularEquipmentPage(driver);
  }
}
