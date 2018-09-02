package com.falabella.test.cl;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.dataprovider.IntegratedDataProvider;
import com.entities.Product;
import com.falabella.pages.cl.HomePage;
import com.falabella.pages.cl.PDPPage;
import com.seleniumTest.BaseConfig;

public class T2 extends BaseConfig {
  
  @Test(dataProvider = "Product2Falabella", dataProviderClass = IntegratedDataProvider.class)
  @Parameters({ "browserRun" })
  private void Searh_Product_In_HomePage_2(Product product) {
    HomePage homePage = new HomePage(driver);
    homePage.SearhSku(product.Sku());
    PDPPage pdpPage = new PDPPage(driver);
    Assert.assertTrue(pdpPage.valid_PDP_Product(),"Div Product is not display");
  }
}
