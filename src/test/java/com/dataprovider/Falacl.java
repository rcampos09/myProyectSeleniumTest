package com.dataprovider;

import org.testng.annotations.DataProvider;
import com.conexion.Connection;

public class Falacl {

  @DataProvider
  public static void main(String[] args) {
    Connection conexion = new Connection();
    System.out.println("1");
    conexion.view_product_rt();
  }
}
