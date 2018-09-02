package com.dataprovider;

import org.testng.annotations.DataProvider;
import com.entities.Product;
import com.google.gson.Gson;
import com.seleniumTest.BaseConfig;

public class IntegratedDataProvider extends BaseConfig {

  @DataProvider
  public static Object[][] ProductFalabella() {
    Gson gson = new Gson();
    Product product =
        gson.fromJson(
            FileDataProvider.asString(
                String.format("src/test/resources/cl/product.json")),
            Product.class);
    return new Object[][] {{product}};
  }
  
  @DataProvider
  public static Object[][] Product2Falabella() {
    Gson gson = new Gson();
    Product product =
        gson.fromJson(
            FileDataProvider.asString(
                String.format("src/test/resources/cl/product2.json")),
            Product.class);
    return new Object[][] {{product}};
  }
}
