package com.falabella.test.cl;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.falabella.config.BaseConfig;
import com.falabella.dataprovider.IntegratedDataProvider;
import com.falabella.entities.Product;
import com.falabella.pages.cl.HomePage;
import com.falabella.pages.cl.PDPPage;

public class T2 extends BaseConfig {
  
  @Test(dataProvider = "Product2Falabella", dataProviderClass = IntegratedDataProvider.class)
  private void Searh_Product_In_HomePage_2(Product product) {
    HomePage homePage = new HomePage(driver);
    homePage.SearhSku(product.Sku());
    PDPPage pdpPage = new PDPPage(driver);
    Assert.assertTrue(pdpPage.valid_PDP_Product(),"Div Product is not display");
  }
}
