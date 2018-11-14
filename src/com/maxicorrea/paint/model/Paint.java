package com.maxicorrea.paint.model;

public class Paint {

  private Brush brush;
  private Image image;
  
  public Paint(Image image , Brush brush) {
    this.image = image;
    this.brush = brush;
  }
  
  public Image getImage() {
    return image;
  }
  
  public Brush getBrush() {
    return brush;
  }
  
}
