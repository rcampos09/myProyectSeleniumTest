package com.website.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.website.config.BaseConfig;
import com.website.dataprovider.IntegratedDataProvider;
import com.website.entities.Product;
import com.website.pages.cl.HomePage;
import com.website.pages.cl.PDPPage;
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
