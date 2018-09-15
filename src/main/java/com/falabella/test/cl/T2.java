package com.falabella.test.cl;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.falabella.config.BaseConfig;
import com.falabella.dataprovider.IntegratedDataProvider;
import com.falabella.entities.Product;
import com.falabella.pages.cl.HomePage;
import com.falabella.pages.cl.PDPPage;
import io.qameta.allure.Description;

public class T2 extends BaseConfig {
  
  @Test(dataProvider = "Product2Falabella", dataProviderClass = IntegratedDataProvider.class)
  @Description("Searh Product in Home")
  private void SearhProductInHomePage2(Product product) {
    HomePage homePage = new HomePage(driver);
    homePage.SearhSku(product.Sku());
    PDPPage pdpPage = new PDPPage(driver);
    Assert.assertTrue(pdpPage.valid_PDP_Product(),"Div Product is not display");
  }
}
