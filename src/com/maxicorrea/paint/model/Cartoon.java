package com.maxicorrea.paint.model;

import java.util.ArrayDeque;

public class Cartoon {

  public static Cartoon createNotLoaded() {
    return new Cartoon(new Size(512, 712));
  }
  
  private final Size size;
  private boolean loaded;
  private Pixel[][] pixels;
  
  public Cartoon(Size size) {
    this.size = size;
    pixels = new Pixel[size.getHeight()][size.getWidth()];
  }

  public void setPixels(Pixel[][] pixels) {
    this.pixels = pixels;
  }
  
  public Pixel[][] getPixels() {
    return pixels;
  }
  
  public void setPixel(int row, int col, Pixel pixel) {
    pixels[row][col] = pixel;
  }

  public Pixel getPixel(int row, int col) {
    return pixels[row][col];
  }

  public boolean isLoaded() {
    return loaded;
  }
  
  public void setLoader(boolean status) {
    loaded = status;
  }
  
  public Size getSize() {
    return size;
  }

  public void fill(Brush brush) {
    Pixel newColor = brush.getColor();
    Location location = brush.getLocation();
    Pixel oldColor = pixels[location.getX()][location.getY()];
    if (!newColor.equals(oldColor)) {
      paint(location, newColor, oldColor);
    }
  }

  private final static int[] X_DIRECTIONS = {1, -1, 0, 0};
  private final static int[] Y_DIRECTIONS = {0, 0, 1, -1};

  private void paint(Location location, Pixel newColor, Pixel oldColor) {
    ArrayDeque<Location> stack = new ArrayDeque<>();
    stack.push(location);
    while (!stack.isEmpty()) {
      Location curLocation = stack.pop();
      pixels[curLocation.getX()][curLocation.getY()] = newColor;
      for (int index = 0; index < 4; ++index) {
        int nx = curLocation.getX() + X_DIRECTIONS[index];
        int ny = curLocation.getY() + Y_DIRECTIONS[index];
        if (containts(nx, ny) && pixels[nx][ny].equals(oldColor)) {
          stack.push(new Location(nx, ny));
        }
      }
    }
  }

  private boolean containts(int nx, int ny) {
    return ny >= 0 && ny < size.getWidth() &&
           nx >= 0 && nx < size.getHeight();
  }

}
