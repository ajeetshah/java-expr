package com.example.demo.learn_java.learn_list;

import java.util.Comparator;

public class Product {

  public static final Comparator<Product> BY_WEIGHT = Comparator.comparingInt(Product::getWeight);
  private int id;
  private String name;
  private Integer weight;

  public Product(String name, Integer weight) {
    this.name = name;
    this.weight = weight;
  }

  public Product(int id, String name, Integer weight) {
    this.id = id;
    this.name = name;
    this.weight = weight;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "{name: '" + this.name + "', " + "weight: '" + this.weight + "'}";
  }

}
