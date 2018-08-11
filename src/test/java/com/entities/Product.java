package com.entities;

import org.springframework.data.annotation.Id; 

public class Product {

  @Id
  public String id;

  public String sku;
  public String store_hd;
  public String store_rt;

  public Product() {}

  public Product(String sku, String store_hd, String store_rt) {
      this.sku = sku;
      this.store_hd = store_hd;
      this.store_rt = store_rt;
  }

  @Override
  public String toString() {
    return String.format(sku, store_hd, store_rt);
  }
}
