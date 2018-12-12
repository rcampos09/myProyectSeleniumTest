package com.website.test.fa;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.website.config.BaseConfig;
import com.website.dataprovider.IntegratedDataProvider;
import com.website.entities.Product;
import com.website.pages.fa.HomePage;
import com.website.pages.fa.PDPPage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;

public class AUT4 extends BaseConfig {

  @Test(dataProvider = "Product3Falabella", 
      dataProviderClass = IntegratedDataProvider.class,
      description = "Searh Product in Homen 3")
  @Story("Sprint 20")
  @Description("Searh Product in Home 3")
  public void SearhProductInHomePage3(Product product) {
    HomePage homePage = new HomePage(driver); 
    homePage.SearhSku(product.Sku());
    PDPPage pdpPage = new PDPPage(driver);
    Assert.assertTrue(pdpPage.valid_PDP_Product(), "Div Product is not display");
  }
}
