package com.example.demo.learn_java;

import java.util.function.UnaryOperator;

public class ProductReplaceAll implements UnaryOperator<Product> {

  private final Product oldProduct;
  private final Product newProduct;

  public ProductReplaceAll(final Product oldProduct, final Product newProduct) {
    this.oldProduct = oldProduct;
    this.newProduct = newProduct;
  }

  public Product apply(Product product) {
    if (product.equals(oldProduct)) {
      return newProduct;
    }
    return product;
  }

}
