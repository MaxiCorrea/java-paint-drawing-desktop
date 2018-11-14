package com.maxicorrea.paint.model;

public class Brush {
  
  private Location location;
  private Pixel color;
  
  public Brush(Location location , Pixel color) {
    this.location = location;
    this.color = color;
  }
  
  public Location getLocation() {
    return location;
  }
  
  public Pixel getColor() {
    return color;
  }
  
}