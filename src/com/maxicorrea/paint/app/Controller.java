package com.maxicorrea.paint.app;

import java.util.List;
import com.maxicorrea.paint.model.Cartoon;
import com.maxicorrea.paint.model.Pixel;
import com.maxicorrea.paint.view.CartoonView;
import com.maxicorrea.paint.view.PaletteView;
import com.maxicorrea.paint.view.SelectorView;

public class Controller {

  private Application application;
  private CartoonView cartoonView;
  private SelectorView selectorView;
  private PaletteView paletteView;

  public Controller(Application application, 
                    CartoonView cartoonView, 
                    SelectorView selectorView,
                    PaletteView paletteView) {

    this.application = application;
    this.cartoonView = cartoonView;
    this.selectorView = selectorView;
    this.paletteView = paletteView;

    initializeCartoonView();
    initializePaletteView();
    initializeSelectorView();
  }

  private void initializeCartoonView() {
    cartoonView.setController(this);
  }

  public void paintIn(int x, int y) {
    application.fillIn(x, y);
    Cartoon cartoon = application.getCartoon();
    cartoonView.updateCartoon(cartoon);
  }

  private void initializePaletteView() {
    List<String> colorsId = application.getPaletteColorIDs();
    List<Pixel> colors = application.getPaletteColors();
    for (int i = 0; i < application.countColors(); ++i) {
      Pixel color = colors.get(i);
      int r = color.getRed();
      int g = color.getGreen();
      int b = color.getBlue();
      String command = colorsId.get(i);
      paletteView.addColor(r, g, b, command);
    }
    paletteView.setController(this);
  }

  public void selectColor(String actionCommand) {
    application.changeBrushColor(actionCommand);
  }

  private void initializeSelectorView() {
    List<String> commands = application.getSelectorIDs();
    List<String> thumbnails = application.getThumbnailsPath();
    for (int i = 0; i < application.countCartoons(); ++i) {
      String thumbnail = thumbnails.get(i);
      String command = commands.get(i);
      selectorView.addSelector(thumbnail, command);
    }
    selectorView.setController(this);
  }

  public void selectAction(String command) {
    application.changeCartoon(command);
    Cartoon cartoon = application.getCartoon();
    cartoonView.updateCartoon(cartoon);
  }

  public void clearCartoon() {
    Cartoon cartoon = application.getCartoon();
    if(cartoon != null) {
      cartoon.clear();
      cartoonView.updateCartoon(cartoon);
    }
  }

  public void printCartoon() {
    String path = cartoonView.getSavePath();
    if(path != null && !path.isEmpty()) {
      application.printCartoon(path);
    }
  }

}
