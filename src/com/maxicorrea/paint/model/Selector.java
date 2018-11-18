package com.maxicorrea.paint.model;

public enum Selector {

  PATO(Cartoon.createNotLoaded()) {
    
    @Override
    public String getThumbnailsPath() {
      return "/thumbnails/pato_donal.png";
    }
    
    @Override
    public String getCartoonPath() {
      return "cartoons/pato_donal.bmp";
    }
  },

  BOB(Cartoon.createNotLoaded()) {
    
    @Override
    public String getThumbnailsPath() {
      return "/thumbnails/bob_esponja.png";
    }
    
    @Override
    public String getCartoonPath() {
      return "cartoons/bob_esponja.bmp";
    }
  },
  
  MINION(Cartoon.createNotLoaded()) {
    @Override
    public String getThumbnailsPath() {
      return "/thumbnails/minions.png";
    }
    
    @Override
    public String getCartoonPath() {
      return "cartoons/minions.bmp";
    }
  };
  
  public Cartoon cartoon;

  private Selector(Cartoon cartoon) {
    this.cartoon = cartoon;
  }

  public abstract String getThumbnailsPath();
  
  public abstract String getCartoonPath();
  
}
