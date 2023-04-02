package com.example.demo.learn_java.learn_list;

import java.util.Arrays;

public class LearnArray {

  public static void main(String[] args) {
    Product door = new Product("Wooden Door 1", 35);
    Product floorPanel = new Product("Floor Panel 2", 25);
    Product glassWindow = new Product("Glass Window 3", 10);

    Product[] products = {door, floorPanel};
    products = add(glassWindow, products);
//    products = add(glassWindow, products);

//    System.out.println(Arrays.toString(products));

    for (Product product : products) {
      System.out.println(product);
    }
  }

  private static Product[] add(Product product, Product[] products) {
    int length = products.length;
    Product[] newProducts = Arrays.copyOf(products, length + 1);
    newProducts[length] = product;
    return newProducts;
  }

}
