package com.falabella.dataprovider;

import org.testng.annotations.DataProvider;
import com.falabella.config.BaseConfig;
import com.falabella.entities.Product;
import com.google.gson.Gson;

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
