package com.example.demo.learn_java.learn_map;

import com.example.demo.learn_java.learn_list.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LookupTableComparison {

  private static final int ITERATIONS = 5;
  private static final int NUMBER_OF_PRODUCTS = 20_000;

  private static final List<Product> products = generateProducts();

  public static void main(String[] args) {
    runLookups(new MapProductLookupTable());
    runLookups(new NaiveProductLookupTable());
  }

  private static List<Product> generateProducts() {
    final List<Product> products = new ArrayList<>();
    final Random weightGenerator = new Random();
    for (int i = 0; i < NUMBER_OF_PRODUCTS; i++) {
      products.add(new Product(i, "Product" + i, 10 + weightGenerator.nextInt()));
    }
    Collections.shuffle(products);
    Collections.shuffle(products);
    return products;
  }

  public static void runLookups(final ProductLookupTable productLookupTable) {
    final List<Product> products = LookupTableComparison.products;
    System.out.println("Running lookup with: " + productLookupTable.getClass().getSimpleName());
    for (int i = 0; i < ITERATIONS; i++) {
      final long startTime = System.currentTimeMillis();
      for (Product product : products) {
        productLookupTable.addProduct(product);
      }
      for (Product product : products) {
        productLookupTable.lookupById(product.getId());
      }
      final long endTime = System.currentTimeMillis();
      System.out.println("Execution Time: " + (endTime - startTime));
      productLookupTable.clear();
    }
  }
}
