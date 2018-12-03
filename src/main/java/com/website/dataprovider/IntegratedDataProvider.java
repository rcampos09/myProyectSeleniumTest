package com.website.dataprovider;

import org.testng.annotations.DataProvider;
import com.google.gson.Gson;
import com.website.config.BaseConfig;
import com.website.entities.Product;

public class IntegratedDataProvider extends BaseConfig {

  @DataProvider
  public static Object[][] ProductFalabella() {
    Gson gson = new Gson();
    String country = System.getProperty("dlx.country");
    Product product =
        gson.fromJson(
            FileDataProvider.asString(
                String.format("src/test/resources/%s/product.json", country )),
            Product.class);
    return new Object[][] {{product}};
  }
  
  @DataProvider
  public static Object[][] Product2Falabella() {
    Gson gson = new Gson();
    String country = System.getProperty("dlx.country");
    Product product =
        gson.fromJson(
            FileDataProvider.asString(
                String.format("src/test/resources/%s/product2.json", country)),
            Product.class);
    return new Object[][] {{product}};
  }
  
  @DataProvider
  public static Object[][] Product3Falabella() {
    Gson gson = new Gson();
    String country = System.getProperty("dlx.country");
    Product product =
        gson.fromJson(
            FileDataProvider.asString(
                String.format("src/test/resources/%s/product3.json", country)),
            Product.class);
    return new Object[][] {{product}};
  }
}
