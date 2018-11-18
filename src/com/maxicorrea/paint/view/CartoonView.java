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
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.maxicorrea.paint.app.Controller;
import com.maxicorrea.paint.model.Cartoon;

public class CartoonView extends JPanel {
  private static final long serialVersionUID = 1L;

  private JLabel cartoonLabel;

  public CartoonView() {
    super(new BorderLayout());
    add(createCartoonLabel(), CENTER);
  }

  private JPanel createCartoonLabel() {
    JPanel pane = new JPanel();
    cartoonLabel = new JLabel();
    cartoonLabel.setBackground(WHITE);
    pane.add(cartoonLabel);
    return pane;
  }

  public void updateCartoon(Cartoon cartoon) {
    int width = cartoon.getSize().getWidth();
    int height = cartoon.getSize().getHeight();
    BufferedImage buffImg = new BufferedImage(width, height, TYPE_INT_ARGB);
    for (int row = 0; row < height; ++row) {
      for (int col = 0; col < width; ++col) {
        int r = cartoon.getPixel(row, col).getRed();
        int g = cartoon.getPixel(row, col).getGreen();
        int b = cartoon.getPixel(row, col).getBlue();
        buffImg.setRGB(col, row, (new Color(r, g, b)).getRGB());
      }
    }
    cartoonLabel.setIcon(new ImageIcon(buffImg));
  }

  public void setController(Controller controller) {
    cartoonLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();
        controller.paintIn(point.x, point.y);
      }
    });
  }

  public String getSavePath() {
    JFileChooser chooser = new JFileChooser();
    if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
      return chooser.getSelectedFile().getAbsolutePath();
    }
    return null;
  }

}
