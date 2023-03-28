package com.example.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.demo.learn_java.Product;
import com.example.demo.learn_java.Shipment;
import org.junit.jupiter.api.Test;

public class ShipmentTest {

  public static final Product woodenDoor = new Product("Wooden Door", 35);
  public static final Product floorPanel = new Product("Floor Panel", 25);
  public static final Product glassWindow = new Product("Glass Window", 10);

  private final Shipment shipment = new Shipment();

  @Test
  public void shouldAddItems() {
    shipment.add(woodenDoor);
    shipment.add(glassWindow);
    assertThat(shipment, contains(woodenDoor, glassWindow));
  }

  @Test
  public void shouldReplaceAll() {
    shipment.add(woodenDoor);
    shipment.add(glassWindow);
    shipment.replaceAll(woodenDoor, floorPanel);
    assertThat(shipment, contains(floorPanel, glassWindow));
  }

  @Test
  public void shouldReplaceItems() {
    shipment.add(woodenDoor);
    shipment.add(glassWindow);
    assertTrue(shipment.replace(woodenDoor, floorPanel));
    assertThat(shipment, contains(floorPanel, glassWindow));
  }

  @Test
  public void shouldNotReplaceMissingItems() {
    shipment.add(glassWindow);
    assertFalse(shipment.replace(woodenDoor, floorPanel));
    assertThat(shipment, contains(glassWindow));
  }

  @Test
  public void shouldIdentifyVanRequirements() {
    shipment.add(woodenDoor);
    shipment.add(glassWindow);
    shipment.add(floorPanel);
    shipment.prepare();
    assertThat(shipment.getLightVanProducts(), contains(glassWindow));
    assertThat(shipment.getHeavyVanProducts(), contains(floorPanel, woodenDoor));
  }

}
