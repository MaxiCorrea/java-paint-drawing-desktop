package com.maxicorrea.paint.view;

import static java.awt.Color.WHITE;
import static javax.swing.BoxLayout.PAGE_AXIS;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.maxicorrea.paint.app.Controller;

public class SelectorView extends JPanel {

  private static final long serialVersionUID = 1L;

  private List<JButton> buttons;

  public SelectorView() {
    buttons = new ArrayList<>();
    setLayout(new BoxLayout(this, PAGE_AXIS));
    setBackground(WHITE);
  }

  public void addSelector(String thumbnail, String command) {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = toolkit.getImage(thumbnail);
    JButton button = new JButton(new ImageIcon(image));
    button.setBackground(Color.WHITE);
    button.setActionCommand(command);
    buttons.add(button);
    add(button);
  }

  public void setController(Controller controller) {
    for (JButton each : buttons) {
      each.addActionListener((e) -> {
        controller.selectAction(e.getActionCommand());
      });
    }
  }

}
