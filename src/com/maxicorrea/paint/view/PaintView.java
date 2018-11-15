package com.maxicorrea.paint.view;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintView extends JFrame {
  private static final long serialVersionUID = 1L;

  private TitleView titleView;
  private BrushView brushView;

  public PaintView(ImageView imageView, PaletteView paletteView) {
    setSize(900, 600);
    titleView = new TitleView(this);
    brushView = new BrushView();
    setCursor(brushView.createCursor());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(titleView, NORTH);
    getContentPane().add(imageView, CENTER);
    getContentPane().add(paletteView, EAST);
    getContentPane().add(createFooterPane(),SOUTH);
    setUndecorated(true);
  }

  private JPanel createFooterPane() {
    JPanel pane = new JPanel();
    pane.setPreferredSize(new Dimension(900 , 30));
    pane.setBackground(new Color(166,193,13));
    return pane;
  }
  
}
