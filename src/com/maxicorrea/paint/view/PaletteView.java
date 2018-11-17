package com.maxicorrea.paint.view;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.WHITE;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.maxicorrea.paint.app.Controller;

public class PaletteView extends JPanel {

  private static final long serialVersionUID = 1L;

  private JPanel centerPane;
  private JPanel southPane;
  private List<ColorView> colorsList = new ArrayList<>();

  public PaletteView() {
    super(new BorderLayout());
    setBackground(WHITE);
    setBorder(new EmptyBorder(10, 10, 10, 10));
    centerPane = new JPanel(new GridLayout(10, 4, 5, 5));
    centerPane.setBackground(Color.WHITE);
    add(centerPane, CENTER);
    southPane = new JPanel();
    southPane.setPreferredSize( new Dimension(120, 100));
    southPane.add(new JButton("Borrar"));
    southPane.add(new JButton("Imprimir"));
    southPane.add(new JButton("Valver"));
    southPane.setBackground(WHITE);
    add(southPane , SOUTH);
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
  }

}
