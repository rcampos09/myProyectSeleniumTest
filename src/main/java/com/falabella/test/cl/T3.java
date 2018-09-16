package com.falabella.test.cl;

import org.testng.Assert;
import org.testng.IHookable;
import org.testng.annotations.Test;
import com.falabella.config.BaseConfig;
import com.falabella.dataprovider.IntegratedDataProvider;
import com.falabella.entities.Product;
import com.falabella.pages.cl.HomePage;
import com.falabella.pages.cl.PDPPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class T3 extends BaseConfig implements IHookable {

  @Test(dataProvider = "Product3Falabella", 
      dataProviderClass = IntegratedDataProvider.class)
  @Story("Sprint 20")
  @Step("Type {product.Sku()}")
  @Description("Searh Product in Home")
  public void SearhProductInHomePage1(Product product) {
    HomePage homePage = new HomePage(driver);
    homePage.SearhSku(product.Sku());
    PDPPage pdpPage = new PDPPage(driver);
    Assert.assertTrue(pdpPage.valid_PDP_Product(), "Div Product is not display");
  }
}