package com.maxicorrea.paint.view;

import static java.awt.BorderLayout.CENTER;
import static java.awt.Color.WHITE;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.maxicorrea.paint.controller.ImageController;
import com.maxicorrea.paint.model.Image;

public class ImageView extends JPanel {
  private static final long serialVersionUID = 1L;

  private JLabel imageLabel;

  public ImageView() {
    super(new BorderLayout());
    add(createImageLabel(), CENTER);
  }

  private JPanel createImageLabel() {
    JPanel pane = new JPanel();
    imageLabel = new JLabel();
    imageLabel.setBackground(WHITE);
    pane.add(imageLabel);
    return pane;
  }

  public void updateImage(Image image) {
    int width = image.getSize().getWidth();
    int height = image.getSize().getHeight();
    BufferedImage buffImg = new BufferedImage(width, height, TYPE_INT_ARGB);
    for (int row = 0; row < height; ++row) {
      for (int col = 0; col < width; ++col) {
        int r = image.getPixel(row, col).getRed();
        int g = image.getPixel(row, col).getGreen();
        int b = image.getPixel(row, col).getBlue();
        buffImg.setRGB(col, row, (new Color(r, g, b)).getRGB());
      }
    }
    imageLabel.setIcon(new ImageIcon(buffImg));
  }

  public void setController(ImageController imageController) {
    imageLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();
        imageController.paintIn(point.x, point.y);
      }
    });
  }

}
