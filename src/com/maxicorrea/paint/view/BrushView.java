package com.maxicorrea.paint.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BrushView extends JLabel {

  private static final long serialVersionUID = 1L;
  
  private ImageIcon icon;
  
  public BrushView() {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = toolkit.getImage("resources/brush.png");
    icon = new ImageIcon(image);
    setIcon(icon);
    setBackground(Color.BLACK);
  }
  
  public Cursor createCursor() {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = icon.getImage();
    Cursor c = toolkit.createCustomCursor(image, new Point(getX(),getY()), "img");
    return c;
  }

}
