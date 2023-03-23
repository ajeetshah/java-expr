package com.example.demo.learn_java;

public class Product {

  private String name;
  private Integer weight;

  public Product(String name, Integer weight) {
    this.name = name;
    this.weight = weight;
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
