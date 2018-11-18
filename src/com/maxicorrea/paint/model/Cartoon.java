package com.maxicorrea.paint.model;

import java.util.ArrayDeque;

public class Cartoon {

  public static Cartoon createNotLoaded() {
    return new Cartoon(new Size(512, 712));
  }

  private Size size;
  private boolean loaded;
  private boolean modified;
  private Pixel[][] originals;
  private Pixel[][] currents;

  public Cartoon(Size size) {
    this.size = size;
    currents = new Pixel[size.getHeight()][size.getWidth()];
    originals = new Pixel[size.getHeight()][size.getWidth()];
  }

  public void setPixels(Pixel[][] pixels) {
    this.currents = pixels;
  }

  public Pixel[][] getPixels() {
    return currents;
  }

  public void setPixel(int row, int col, Pixel pixel) {
    currents[row][col] = pixel;
  }

  public Pixel getPixel(int row, int col) {
    return currents[row][col];
  }

  public boolean isLoaded() {
    return loaded;
  }

  public void markAsLoaded() {
    loaded = true;
    for (int i = 0; i < currents.length; ++i) {
      for (int j = 0; j < currents[i].length; ++j) {
        originals[i][j] = new Pixel(currents[i][j]);
      }
    }
  }

  public Size getSize() {
    return size;
  }

  public void clear() {
    if (isLoaded() && modified) {
      for (int i = 0; i < originals.length; ++i) {
        for (int j = 0; j < originals[i].length; ++j) {
          currents[i][j] = new Pixel(originals[i][j]);
        }
      }
      modified = false;
    }
  }

  public void fill(Brush brush) {
    Pixel newColor = brush.getColor();
    Location location = brush.getLocation();
    Pixel oldColor = currents[location.getX()][location.getY()];
    if (!newColor.equals(oldColor)) {
      paint(location, newColor, oldColor);
      modified = true;
    }
  }

  private final static int[] X_DIRECTIONS = {1, -1, 0, 0};
  private final static int[] Y_DIRECTIONS = {0, 0, 1, -1};

  private void paint(Location location, Pixel newColor, Pixel oldColor) {
    ArrayDeque<Location> stack = new ArrayDeque<>();
    stack.push(location);
    while (!stack.isEmpty()) {
      Location curLocation = stack.pop();
      currents[curLocation.getX()][curLocation.getY()] = newColor;
      for (int index = 0; index < 4; ++index) {
        int nx = curLocation.getX() + X_DIRECTIONS[index];
        int ny = curLocation.getY() + Y_DIRECTIONS[index];
        if (contains(nx, ny) && currents[nx][ny].equals(oldColor)) {
          stack.push(new Location(nx, ny));
        }
      }
    }
  }

  private boolean contains(int nx, int ny) {
    return ny >= 0 && ny < size.getWidth() &&
           nx >= 0 && nx < size.getHeight();
  }

}
