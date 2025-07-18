package render.texture;

import math.vector.Vector4;

public final class Color extends Vector4 {
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
    return Color.from(r, g, b, Integer.MAX_VALUE);
  }

  public static Color from(byte r, byte g, byte b) {
    return Color.from(r, g, b, Byte.MAX_VALUE);
  }

  public static Color from(int argb) {
    final int a = (argb >> 24) & 0xFF;
    final int r = (argb >> 16) & 0xFF;
    final int g = (argb >> 8) & 0xFF;
    final int b = (argb >> 0) & 0xFF;

    return new Color(
        r / 255.0,
        g / 255.0,
        b / 255.0,
        a / 255.0);
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

  public int getARGB() {
    int rgba = (int)(a() * 0xFF);
    rgba = (rgba << 8) | (int)(r() * 0xFF);
    rgba = (rgba << 8) | (int)(g() * 0xFF);
    rgba = (rgba << 8) | (int)(b() * 0xFF);
    return rgba;
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
