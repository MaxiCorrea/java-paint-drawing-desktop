package com.maxicorrea.paint.model;

public class Size {

  private final int height;
  private final int width;

  public Size(int height, int width) {
    this.height = height;
    this.width = width;
  }

  public Size(Size other) {
    this(other.getHeight(), other.getWidth());
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

}

