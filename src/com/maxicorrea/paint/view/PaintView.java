package com.maxicorrea.paint.view;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import javax.swing.JFrame;

public class PaintView extends JFrame {
  private static final long serialVersionUID = 1L;

  private BrushView brushView;

  public PaintView(ImageView imageView, PaletteView paletteView) {
    setSize(1_100, 580);
    brushView = new BrushView();
    setCursor(brushView.createCursor());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(imageView, CENTER);
    getContentPane().add(paletteView, EAST);
  }

}
