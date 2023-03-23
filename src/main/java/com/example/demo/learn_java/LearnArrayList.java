package com.example.demo.learn_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class LearnArrayList {

  public static void main(String[] args) {
    Product door = new Product("Wooden Door 1", 35);
    Product floorPanel = new Product("Floor Panel 2", 25);
    Product glassWindow = new Product("Glass Window 3", 10);

    Collection<Product> products = new ArrayList<>();
    products.add(door);
    products.add(floorPanel);
    products.add(glassWindow);

//    for (Product product: products) {
//      if (product.getWeight() > 20) {
//        products.remove(product);
//      }
//      System.out.println(product);
//    }

    Iterator<Product> iterator = products.iterator();
    while (iterator.hasNext()) {
      Product product = iterator.next();
      if (product.getWeight() > 20) {
        iterator.remove();
      }
    }
    System.out.println(products);
    System.out.println(products.size());
    System.out.println(products.isEmpty());
    System.out.println(products.contains(glassWindow));
    System.out.println(products.remove(door));
    System.out.println(products.contains(new Product("Glass Window 3", 10)));
    products.add(floorPanel);
    products.add(floorPanel);
    System.out.println(products.hashCode());

    System.out.println(products);

    Collection<Integer> integers = new ArrayList<>();
    integers.add(1);
    integers.add(2);
    integers.add(3);
    integers.add(4);

    Collection<Integer> toRetain = new ArrayList<>();
    toRetain.add(10);
    toRetain.add(2);
    toRetain.add(30);
    toRetain.add(4);

    integers.retainAll(toRetain);
    System.out.println(integers);
  }

}
