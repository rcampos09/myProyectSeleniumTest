package com.falabella.test.web;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.falabella.config.BaseConfig;
import com.falabella.dataprovider.IntegratedDataProvider;
import com.falabella.entities.Product;
import com.falabella.pages.cl.HomePage;
import com.falabella.pages.cl.PDPPage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;

public class T1 extends BaseConfig {

  @Test(dataProvider = "ProductFalabella", 
      dataProviderClass = IntegratedDataProvider.class,
      description = "Searh Product in Home 1")
  @Story("Sprint 20")
  @Description("Searh Product in Home 1")
  public void SearhProductInHomePage1(Product product) {
    HomePage homePage = new HomePage(driver);
    homePage.SearhSku(product.Sku());
    PDPPage pdpPage = new PDPPage(driver);
    Assert.assertTrue(pdpPage.valid_PDP_Product(), "Div Product is not display");
  }
}
