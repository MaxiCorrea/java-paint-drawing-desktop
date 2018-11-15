package com.maxicorrea.paint.view;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import javax.swing.JButton;

public class ColorView extends JButton {

  private static final long serialVersionUID = 1L;

  public ColorView() {
    super("");
    setOpaque(false);
    setFocusPainted(false);
    setBorderPainted(false);
  }

  @Override
  public Dimension getPreferredSize() {
    FontMetrics metrics = getGraphics().getFontMetrics(getFont());
    int minDiameter = 10 + Math.max(metrics.stringWidth(getText()), metrics.getHeight());
    return new Dimension(minDiameter, minDiameter);
  }

  @Override
  public boolean contains(int x, int y) {
    int radius = getDiameter() / 2;
    return Point2D.distance(x, y, getWidth() / 2, getHeight() / 2) < radius;
  }

  @Override
  public void paintComponent(Graphics g) {
    int diameter = getDiameter();
    int radius = diameter / 2;
    g.setColor(getBackground());
    g.fillOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);
    g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);
    g.setFont(getFont());
    FontMetrics metrics = g.getFontMetrics(getFont());
    int strWidth = metrics.stringWidth(getText());
    int strHeight = metrics.getHeight();
    g.drawString(getText(), getWidth() / 2 - strWidth / 2, getHeight() / 2 + strHeight / 4);
  }

  private int getDiameter() {
    int diameter = Math.min(getWidth(), getHeight());
    return diameter;
  }

}
