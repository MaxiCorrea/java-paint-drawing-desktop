package com.maxicorrea.paint.model;

public enum Palette {

  COLOR_01(new Pixel(207,0,27)),
  COLOR_02(new Pixel(222,96,19)),
  COLOR_03(new Pixel(237,167,11)),
  COLOR_04(new Pixel(250,230,15)),
  COLOR_05(new Pixel(176,207,15)),
  COLOR_06(new Pixel(211,221,11)),
  COLOR_07(new Pixel(238,238,15)),
  COLOR_08(new Pixel(249,247,6)),
  COLOR_09(new Pixel(123,197,41)),
  COLOR_10(new Pixel(92,149,38)),
  COLOR_11(new Pixel(9,130,54)),
  COLOR_12(new Pixel(11,132,127)),
  COLOR_13(new Pixel(11,93,155)),
  COLOR_14(new Pixel(187,226,238)),
  COLOR_15(new Pixel(15,166,218)),
  COLOR_16(new Pixel(11,143,184)),
  COLOR_17(new Pixel(11,118,154)),
  COLOR_18(new Pixel(8,84,124)),
  COLOR_19(new Pixel(92,69,149)),
  COLOR_20(new Pixel(72,14,94)),
  COLOR_21(new Pixel(208,0,119)),
  COLOR_22(new Pixel(207,111,167)),
  COLOR_23(new Pixel(171,102,168)),
  COLOR_24(new Pixel(127,5,120)),
  COLOR_25(new Pixel(231,141,154)),
  COLOR_26(new Pixel(130,150,191)),
  COLOR_27(new Pixel(248,215,232)),
  COLOR_28(new Pixel(239,188,195)),
  COLOR_29(new Pixel(173,132,75)),
  COLOR_30(new Pixel(227,175,90)),
  COLOR_31(new Pixel(229,176,158)),
  COLOR_32(new Pixel(230,137,150)),
  COLOR_33(new Pixel(109,70,17)),
  COLOR_34(new Pixel(255,255,255)),
  COLOR_35(new Pixel(233,233,235)),
  COLOR_36(new Pixel(218,218,220)),
  COLOR_37(new Pixel(176,176,176)),
  COLOR_38(new Pixel(135,135,136)),
  COLOR_39(new Pixel(88,88,90)),
  COLOR_40(new Pixel(0,0,0));
  
  private Pixel color;
  
  private Palette(Pixel color) {
    this.color = color;
  }
  
  public Pixel getColor() {
    return color;
  }
  
}
