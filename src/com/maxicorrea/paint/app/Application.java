package com.maxicorrea.paint.app;

import java.util.ArrayList;
import java.util.List;
import com.maxicorrea.paint.io.CartoonReader;
import com.maxicorrea.paint.io.CartoonWriter;
import com.maxicorrea.paint.model.Brush;
import com.maxicorrea.paint.model.Cartoon;
import com.maxicorrea.paint.model.Location;
import com.maxicorrea.paint.model.Palette;
import com.maxicorrea.paint.model.Pixel;
import com.maxicorrea.paint.model.Selector;

public class Application {

  private Brush brush;
  private Cartoon cartoon;
  private CartoonReader reader;
  private CartoonWriter writer;

  public Application(Brush brush, 
                     CartoonReader reader, 
                     CartoonWriter writer) {

    this.brush = brush;
    this.reader = reader;
    this.writer = writer;
  }

  public void printCartoon(String path){
    if(cartoon != null) {
      writer.write(cartoon,path);
    }
  }
    
  public void changeCartoon(String idSelector) {
    Selector selector = Selector.valueOf(idSelector);
    if (!selector.cartoon.isLoaded()) {
      String path = selector.getCartoonPath();
      Cartoon c = reader.read(path);
      Pixel[][] pixels = c.getPixels();
      selector.cartoon.setPixels(pixels);
      selector.cartoon.markAsLoaded();
    }
    cartoon = selector.cartoon;
  }

  public List<String> getSelectorIDs() {
    List<String> ids = new ArrayList<>();
    for (Selector selector : Selector.values()) {
      ids.add(selector.toString());
    }
    return ids;
  }
  
  public List<String> getThumbnailsPath() {
    List<String> paths = new ArrayList<>();
    for(Selector selector : Selector.values()) {
      paths.add(selector.getThumbnailsPath());
    }
    return paths;
  }
  
  public void changeBrushColor(String colorId) {
    Palette item = Palette.valueOf(colorId);
    Pixel color = item.getColor();
    brush.setColor(color);
  }
  
  public List<String> getPaletteColorIDs() {
    List<String> ids = new ArrayList<>();
    for (Palette palette : Palette.values()) {
      ids.add(palette.toString());
    }
    return ids;
  }

  public List<Pixel> getPaletteColors() {
    List<Pixel> pixels = new ArrayList<>();
    for(Palette palette : Palette.values()) {
      pixels.add(palette.getColor());
    }
    return pixels;
  }
  
  public void fillIn(int x, int y) {
    if(cartoon != null) {
      brush.setLocation(new Location(y, x));
      cartoon.fill(brush);
    }
  }

  public Cartoon getCartoon() {
    return cartoon;
  }
  
  public int countCartoons() {
    return Selector.values().length;
  }
  
  public int countColors() {
    return Palette.values().length;
  }
  
}
