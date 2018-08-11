package com.falabella.test.cl;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.falabella.pages.cl.HomePage;
import com.falabella.pages.cl.PDPPage;
import com.seleniumTest.BaseConfig;

public class T1 extends BaseConfig {

  @Test()
  private void Searh_Product_In_HomePage_1() {
    HomePage homePage = new HomePage(driver);
    homePage.SearhSku("6245851");
    PDPPage pdpPage = new PDPPage(driver);
    Assert.assertTrue(pdpPage.valid_PDP_Product(), "Div Product is not display");
  }
}
