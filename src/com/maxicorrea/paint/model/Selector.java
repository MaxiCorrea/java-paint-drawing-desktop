package com.maxicorrea.paint.model;

public enum Selector {

  PATO(Cartoon.createNotLoaded()) {
    
    @Override
    public String getThumbnailsPath() {
      return "resources/thumbnails/pato_donal.png";
    }
    
    @Override
    public String getCartoonPath() {
      return "resources/cartoons/pato_donal.bmp";
    }
  },

  BOB(Cartoon.createNotLoaded()) {
    
    @Override
    public String getThumbnailsPath() {
      return "resources/thumbnails/bob_esponja.png";
    }
    
    @Override
    public String getCartoonPath() {
      return "resources/cartoons/bob_esponja.bmp";
    }
  };
  
  public Cartoon cartoon;

  private Selector(Cartoon cartoon) {
    this.cartoon = cartoon;
  }

  public abstract String getThumbnailsPath();
  
  public abstract String getCartoonPath();
  
}
