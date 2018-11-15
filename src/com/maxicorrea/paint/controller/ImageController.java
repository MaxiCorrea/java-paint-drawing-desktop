package com.maxicorrea.paint.controller;

import com.maxicorrea.paint.model.Brush;
import com.maxicorrea.paint.model.Image;
import com.maxicorrea.paint.model.Location;
import com.maxicorrea.paint.view.ImageView;

public class ImageController {

  private Image image;
  private Brush brush;
  private ImageView imageView;

  public ImageController(Image image, Brush brush, ImageView imageView) {
    this.image = image;
    this.brush = brush;
    this.imageView = imageView;
    initializeView();
  }

  private void initializeView() {
    imageView.updateImage(image);
    imageView.setController(this);
  }
  
  public void paintIn(int x, int y) {
    brush.setLocation(new Location(y, x));
    image.fill(brush);
    imageView.updateImage(image);
  }

}
