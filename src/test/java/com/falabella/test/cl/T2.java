package com.falabella.test.cl;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.falabella.pages.cl.HomePage;
import com.falabella.pages.cl.PDPPage;
import com.seleniumTest.BaseConfig;

public class T2 extends BaseConfig {
  
  @Test()
  private void Searh_Product_In_HomePage_2() {
    HomePage homePage = new HomePage(driver);
    homePage.SearhSku("881271905");
    PDPPage pdpPage = new PDPPage(driver);
    Assert.assertFalse(pdpPage.valid_PDP_Product(),"Div Product is not display");
  }
}
