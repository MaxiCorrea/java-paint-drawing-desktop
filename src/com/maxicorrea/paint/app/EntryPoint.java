package com.maxicorrea.paint.app;


import com.maxicorrea.paint.io.CartoonReader;
import com.maxicorrea.paint.io.CartoonWriter;
import com.maxicorrea.paint.model.Brush;
import com.maxicorrea.paint.view.CartoonView;
import com.maxicorrea.paint.view.PaintView;
import com.maxicorrea.paint.view.PaletteView;
import com.maxicorrea.paint.view.SelectorView;

public class EntryPoint {

  public static void main(String[] args)  {
    Brush brush = Brush.createDefault();
    CartoonReader reader = new CartoonReader();
    CartoonWriter writer = new CartoonWriter();
    Application application = new Application(brush, reader, writer);
    CartoonView cartoonView = new CartoonView();
    SelectorView selectorView = new SelectorView();
    PaletteView paletteView = new PaletteView();
    new Controller(application, cartoonView, selectorView, paletteView);
    new PaintView(selectorView, cartoonView, paletteView).showApp();;
  }

}
