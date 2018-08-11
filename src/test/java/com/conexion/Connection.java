package com.conexion;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class Connection {

  DB BaseDatos;
  DBCollection collection;
  BasicDBObject docment = new BasicDBObject();
  BasicDBObject whereQuery = new BasicDBObject();

  public Connection() {
    try {

      Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
      mongoLogger.setLevel(Level.SEVERE);

      Mongo mongo = new Mongo("localhost", 27017);
      BaseDatos = mongo.getDB("SeleniumDB");
      System.out.println("Connect to database successfuly¡");

    } catch (Exception e) {
      System.out.println("Not Connect to database¡");
    }
  }

  public void view_all_product() {
    collection = BaseDatos.getCollection("pruduct_falabella");
    DBCursor cursor = collection.find();
    while (cursor.hasNext()) {
      System.out.println(cursor.next());
    }
  }

  public void view_product_rt() {
    whereQuery.put("store_rt","1");
    collection = BaseDatos.getCollection("pruduct_falabella");
    DBCursor cursor = collection.find(whereQuery);
    while (cursor.hasNext()) {
      System.out.println(cursor.next());
    }
  }
  
  public void view_product_hd() {
    whereQuery.put("store_hd","1");
    collection = BaseDatos.getCollection("pruduct_falabella");
    DBCursor cursor = collection.find(whereQuery);
    while (cursor.hasNext()) {
      System.out.println(cursor.next());
    }
  }
}
