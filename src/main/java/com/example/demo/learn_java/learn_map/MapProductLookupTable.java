package com.example.demo.learn_java.learn_map;

import com.example.demo.learn_java.learn_list.Product;
import java.util.HashMap;
import java.util.Map;

public class MapProductLookupTable implements ProductLookupTable {

  private Map<Integer, Product> idToProducts = new HashMap<>();

  @Override
  public Product lookupById(int id) {
    return idToProducts.get(id);
  }

  @Override
  public void addProduct(final Product productToAdd) {
    int id = productToAdd.getId();
    if (idToProducts.containsKey(id)) {
      throw new IllegalArgumentException("Unable to add product - duplicate product for " + productToAdd);
    }
    idToProducts.put(id, productToAdd);
  }

  @Override
  public void clear() {
    idToProducts.clear();
  }
}
