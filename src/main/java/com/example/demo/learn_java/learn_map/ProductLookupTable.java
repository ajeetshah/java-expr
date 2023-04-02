package com.example.demo.learn_java.learn_map;

import com.example.demo.learn_java.learn_list.Product;

public interface ProductLookupTable {

  Product lookupById(int id);

  void addProduct(Product product);

  void clear();
}
