package com.maxicorrea.paint.model;

public class Brush {

  private Location location;
  private Pixel color;

  public static Brush createDefault() {
    Location location = new Location(0,0);
    Pixel black = new Pixel(0,0,0);
    return new Brush(location, black);
  }
  
  public Brush(Location location, Pixel color) {
    this.location = location;
    this.color = color;
  }

  public Location getLocation() {
    return location;
  }

  public Pixel getColor() {
    return color;
  }

  public void setColor(Pixel color) {
    this.color = color;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

}
