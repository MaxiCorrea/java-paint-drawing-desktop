package com.maxicorrea.paint.controller;

import com.maxicorrea.paint.model.Brush;
import com.maxicorrea.paint.model.Palette;
import com.maxicorrea.paint.model.Pixel;
import com.maxicorrea.paint.view.PaletteView;

public class PaletteController {

  private Brush brush;
  private PaletteView paletteView;
  
  public PaletteController(Brush brush , PaletteView paletteView) {
    this.brush = brush;
    this.paletteView = paletteView;
    initializeView();
  }
  
  public void selectColor(String name) {
    brush.setColor(Palette.valueOf(name).getColor());
  }
  
  private void initializeView() {
    for(Palette palette : Palette.values()) {
      Pixel pixel = palette.getColor();
      int r = pixel.getRed();
      int g = pixel.getGreen();
      int b = pixel.getBlue();
      String command = palette.toString();
      paletteView.addColor(r, g, b, command);
    }
    paletteView.setController(this);
  }
  
}
