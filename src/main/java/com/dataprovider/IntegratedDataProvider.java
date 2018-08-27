package com.dataprovider;

import org.testng.annotations.DataProvider;
import com.entities.Product;
import com.google.gson.Gson;

public class IntegratedDataProvider {

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
}
