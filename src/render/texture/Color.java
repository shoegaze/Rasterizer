package render.texture;

import math.vector.Vector4;

public class Color extends Vector4 {
  private static double normalize(double value) {
    return Math.max(Math.min(value, 1), 0);
  }

  private static double normalize(int value) {
    // https://www.khronos.org/opengl/wiki/Normalized_Integer
    return (Math.max((double)value / Integer.MAX_VALUE, -1) + 1) / 2;
  }

  private static double normalize(byte value) {
    return (double)(value + Byte.MAX_VALUE+1) / 255;
  }

  public static Color from(byte r, byte g, byte b, byte a) {
    return new Color(normalize(r), normalize(g), normalize(b), normalize(a));
  }

  public static Color from(int r, int g, int b, int a) {
    return new Color(normalize(r), normalize(g), normalize(b), normalize(a));
  }

  public static Color from(int r, int g, int b) {
    return new Color(r, g, b, Integer.MAX_VALUE);
  }

  public static Color from(byte r, byte g, byte b) {
    return new Color(r, g, b, Byte.MAX_VALUE);
  }

  public static Color from(int y) {
    return new Color(normalize(y));
  }

  public static Color from(byte y) {
    return new Color(normalize(y));
  }


  public Color(double r, double g, double b, double a) {
    super(
        normalize(r),
        normalize(g),
        normalize(b),
        normalize(a));
  }

  public Color(double r, double g, double b) {
    this(r, g, b, 1.0);
  }

  public Color(double y) {
    this(y, y, y);
  }

  @Override
  public String toString() {
    return "Color(" + r() + ", " + g() + ", " + b() + ", " + a() + ")";
  }

  public double r() {
    return x();
  }

  public double g() {
    return y();
  }

  public double b() {
    return z();
  }

  public double a() {
    return w();
  }

  public double luminance() {
    // https://www.itu.int/rec/R-REC-BT.601
    return 0.299*r() + 0.587*g() + 0.114*b();
  }

  // TODO: Make static
  public java.awt.Color toAwtColor() {
    return new java.awt.Color((float)r(), (float)g(), (float)b(), (float)a());
  }

  public double get(int i) {
    return getElement(i);
  }

  public byte getByte(int i) {
    return (byte)(TextureType.BYTE_UNSIGNED_MAX*get(i) + Byte.MIN_VALUE);
  }

  public int getInt(int i) {
    return (int)(TextureType.INT_UNSIGNED_MAX*get(i) + Integer.MIN_VALUE);
  }

  public float getFloat(int i) {
    return (float)get(i);
  }

  public void set(int i, double value) {
    setElement(i, normalize(value));
  }

  public void set(int i, float value) {
    set(i, normalize(value));
  }

  public void set(int i, int value) {
    set(i, normalize(value));
  }

  public void set(int i, byte value) {
    set(i, normalize(value));
  }
}
