package com.maxicorrea.paint.view;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.WHITE;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.maxicorrea.paint.app.Controller;

public class PaletteView extends JPanel {

  private static final long serialVersionUID = 1L;

  private JPanel centerPane;
  private List<ColorView> colorsList = new ArrayList<>();
  private JButton deleteButton;
  private JButton printButton;

  public PaletteView() {
    super(new BorderLayout());
    setBackground(WHITE);
    setBorder(new EmptyBorder(10, 10, 10, 10));
    centerPane = new JPanel(new GridLayout(10, 4, 5, 5));
    centerPane.setBackground(WHITE);
    add(centerPane, CENTER);
    add(createSouthPane(), SOUTH);
  }

  private JPanel createSouthPane() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    pane.setPreferredSize(new Dimension(120, 100));
    deleteButton = createButtonWithIcon("/delete.png");
    pane.add(deleteButton);
    printButton = createButtonWithIcon("/print.png");
    pane.add(printButton);
    return pane;
  }

  private JButton createButtonWithIcon(String iconPath) {
    JButton button = new JButton();
    button.setBackground(WHITE);
    button.setBorderPainted(false);
    button.setFocusPainted(false);
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = toolkit.getImage(getClass().getResource(iconPath));
    button.setIcon(new ImageIcon(image));
    int width = image.getWidth(null);
    int height = image.getHeight(null);
    button.setPreferredSize(new Dimension(width, height));
    return button;
  }

  public void addColor(int r, int g, int b, String command) {
    Color color = new Color(r, g, b);
    ColorView colorView = new ColorView();
    colorView.setBackground(color);
    colorView.setActionCommand(command);
    centerPane.add(colorView);
    colorsList.add(colorView);
  }

  public void setController(Controller controller) {
    for (JButton button : colorsList) {
      button.addActionListener((e) -> {
        controller.selectColor(e.getActionCommand());
      });
    }
    deleteButton.addActionListener((e)->{
      controller.clearCartoon();
    });
    
    printButton.addActionListener((e)->{
      controller.printCartoon();
    });
    
  }

}
