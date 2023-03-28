package com.example.demo.learn_java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product> {

  private static final int LIGHT_VAN_MAX_WEIGHT = 20;
  private static final int MISSING_PRODUCT = -1;
  private final List<Product> products = new ArrayList<>();
  private List<Product> heavyVanProducts = new ArrayList<>();
  private List<Product> lightVanProducts = new ArrayList<>();

  public void add(Product product) {
    products.add(product);
  }

  public boolean replace(final Product oldProduct, final Product newProduct) {
    int position = products.indexOf(oldProduct);
    if (position == MISSING_PRODUCT) {
      return false;
    }
    products.set(position, newProduct);
    return true;
  }

  public void replaceAll(final Product oldProduct, final Product newProduct) {
    products.replaceAll(new ProductReplaceAll(oldProduct, newProduct));
  }

  public List<Product> getHeavyVanProducts() {
    return heavyVanProducts;
  }

  public List<Product> getLightVanProducts() {
    return lightVanProducts;
  }

  public List<Product> getProducts() {
    return products;
  }

  @Override
  public Iterator<Product> iterator() {
    return products.iterator();
  }

  public void prepare() {
    products.sort(Product.BY_WEIGHT);
    int splitPoint = findSplitPoint();
    lightVanProducts = products.subList(0, splitPoint);
    heavyVanProducts = products.subList(splitPoint, products.size());
  }

  private int findSplitPoint() {
    int size = products.size();
    for (int i = 0; i < size; i++) {
      Product product = products.get(i);
      if (product.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
        return i;
      }
    }
    return 0;
  }
}
