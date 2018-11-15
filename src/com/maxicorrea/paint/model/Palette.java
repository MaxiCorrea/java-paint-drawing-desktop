package com.maxicorrea.paint.model;

public enum Palette {

  COLOR_01(new Pixel(25,45,55)),
  COLOR_02(new Pixel(33,55,66)),
  COLOR_03(new Pixel(10,10,15)),
  COLOR_04(new Pixel(45,67,77)),
  COLOR_05(new Pixel(56,67,18)),
  COLOR_06(new Pixel(56,78,19)),
  COLOR_07(new Pixel(56,78,13)),
  COLOR_08(new Pixel(10,10,12)),
  COLOR_09(new Pixel(45,67,18)),
  COLOR_10(new Pixel(45,67,21)),
  COLOR_11(new Pixel(255,255,255)),
  COLOR_12(new Pixel(255,0,0)),
  COLOR_13(new Pixel(45,47,34)),
  COLOR_14(new Pixel(45,47,34)),
  COLOR_15(new Pixel(45,47,34)),
  COLOR_16(new Pixel(0,255,0)),
  COLOR_17(new Pixel(45,47,34)),
  COLOR_18(new Pixel(45,47,34)),
  COLOR_19(new Pixel(45,47,34)),
  COLOR_20(new Pixel(0,0,255)),
  COLOR_21(new Pixel(45,47,34)),
  COLOR_22(new Pixel(45,47,34)),
  COLOR_23(new Pixel(45,47,34)),
  COLOR_24(new Pixel(45,47,34)),
  COLOR_25(new Pixel(45,47,34)),
  COLOR_26(new Pixel(45,47,34)),
  COLOR_27(new Pixel(45,47,34)),
  COLOR_28(new Pixel(45,47,34)),
  COLOR_29(new Pixel(45,47,34)),
  COLOR_30(new Pixel(45,47,34)),
  COLOR_31(new Pixel(45,47,34)),
  COLOR_32(new Pixel(45,47,34)),
  COLOR_33(new Pixel(45,47,34)),
  COLOR_34(new Pixel(45,47,34)),
  COLOR_35(new Pixel(45,47,34)),
  COLOR_36(new Pixel(45,47,34)),
  COLOR_37(new Pixel(45,47,34)),
  COLOR_38(new Pixel(45,47,34)),
  COLOR_39(new Pixel(45,47,34)),
  COLOR_40(new Pixel(45,47,34));
  
  private Pixel color;
  
  private Palette(Pixel color) {
    this.color = color;
  }
  
  public Pixel getColor() {
    return color;
  }
  
}
