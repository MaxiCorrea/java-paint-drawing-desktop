package com.maxicorrea.paint.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.maxicorrea.paint.model.Cartoon;
import com.maxicorrea.paint.model.Pixel;
import com.maxicorrea.paint.model.Size;

public class CartoonWriter {

  public void write(Cartoon cartoon , String path) {
    File file = new File(path);
    try (FileOutputStream fo = new FileOutputStream(addExtension(file));
        BufferedOutputStream bo = new BufferedOutputStream(fo)) {
      writeBitmapFileHeader(bo, cartoon.getSize());
      writeBitmapInfoHeader(bo, cartoon.getSize());
      writePixels(bo, cartoon);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private File addExtension(File file) {
    if (!file.getAbsolutePath().endsWith(".bmp")) {
      return new File(file.getAbsolutePath().concat(".bmp"));
    }
    return file;
  }
  
  private void writeBitmapFileHeader(BufferedOutputStream bo, Size size) throws IOException {
    bo.write(new byte[] {BmpConstants.CHARACTER_B, BmpConstants.CHARACTER_M});
    bo.write(toInt(size.getWidth() * size.getHeight() * 3 + 
                   size.getHeight() * (size.getWidth() % 4) + 54));
    bo.write(toShort(0));
    bo.write(toShort(0));
    bo.write(toInt(54));
  }
  
  private void writeBitmapInfoHeader(BufferedOutputStream bo, Size size) throws IOException {
    bo.write(toInt(BmpConstants.HEAD_SIZE));
    bo.write(toInt(size.getWidth()));
    bo.write(toInt(size.getHeight()));
    bo.write(toShort(BmpConstants.IMAGE_PLANS));
    bo.write(toShort(BmpConstants.BITS_PER_PIXEL));
    bo.write(toInt(BmpConstants.COMPRESSION));
    bo.write(toInt(size.getWidth() * size.getHeight() * 3 + 
                   size.getHeight() * (size.getWidth() % 4)));
    bo.write(toInt(0));
    bo.write(toInt(0));
    bo.write(toInt(0));
    bo.write(toInt(0));
  }
  
  private void writePixels(BufferedOutputStream bo, Cartoon cartoon) throws IOException {
    Size size = cartoon.getSize();
    int padding = size.getWidth() % BmpConstants.PADDING;
    for (int i = size.getHeight() - 1; i >= 0; i--) {
      for (int j = 0; j < size.getWidth(); j++) {
        bo.write((byte) cartoon.getPixel(i, j).getBlue());
        bo.write((byte) cartoon.getPixel(i, j).getGreen());
        bo.write((byte) cartoon.getPixel(i, j).getRed());
      }
      for (int x = 0; x < padding; x++)
        bo.write(Pixel.MAX_VALUE);
    }
  }

  private byte[] toInt(int value) {
    byte[] b = new byte[4];
    b[0] = ((byte) (value & 0xFF));
    b[1] = ((byte) (value >> 8 & 0xFF));
    b[2] = ((byte) (value >> 16 & 0xFF));
    b[3] = ((byte) (value >> 24 & 0xFF));
    return b;
  }

  private byte[] toShort(int value) {
    byte[] bytes = new byte[2];
    bytes[0] = ((byte) (value & 0xFF));
    bytes[1] = ((byte) (value >> 8 & 0xFF));
    return bytes;
  }
  
}
