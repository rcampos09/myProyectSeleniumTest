package com.website.test.wo;

import org.testng.annotations.Test;
import com.website.config.BaseConfig;
import com.website.dataprovider.IntegratedDataProvider;
import com.website.entities.Product;
import com.website.pages.wo.CellularEquipmentPage;
import com.website.pages.wo.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;

public class W1 extends BaseConfig {

  @Test(dataProvider = "Phone1Wom", 
      dataProviderClass = IntegratedDataProvider.class,
      description = "Searh Phone in Home 1")
  @Story("Sprint 11")
  @Description("Searh Phone in Home 1")
  public void SearhPhoneInHomePage1(Product product) {
    HomePage homePage = new HomePage(driver);
    CellularEquipmentPage cellularEquipmentPage = homePage.click_Equipos_menu();
    cellularEquipmentPage.search_Equipos("iphone xr");
  }
}
