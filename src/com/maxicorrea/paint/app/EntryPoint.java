package com.maxicorrea.paint.app;


import java.io.File;
import java.io.IOException;
import com.maxicorrea.paint.controller.ImageController;
import com.maxicorrea.paint.controller.PaletteController;
import com.maxicorrea.paint.io.BmpInputException;
import com.maxicorrea.paint.io.ImageReader;
import com.maxicorrea.paint.model.Brush;
import com.maxicorrea.paint.model.Image;
import com.maxicorrea.paint.model.Location;
import com.maxicorrea.paint.model.Pixel;
import com.maxicorrea.paint.view.ImageView;
import com.maxicorrea.paint.view.PaintView;
import com.maxicorrea.paint.view.PaletteView;

public class EntryPoint {

  public static void main(String[] args) throws IOException, BmpInputException {
    app();
  }

  private static void app() throws IOException, BmpInputException {
    PaletteView paletteView = new PaletteView();
    ImageView imageView = new ImageView();
    Brush brush = new Brush(new Location(10, 10), new Pixel(3, 3, 4));
    new PaletteController(brush, paletteView);
    Image image = new ImageReader().read(new File("resources/bob_esponja.bmp"));
    new ImageController(image, brush, imageView);
    PaintView paintView = new PaintView(imageView, paletteView);
    paintView.setLocationRelativeTo(null);
    paintView.setVisible(true);
  }
  
}
