package render.texture;

public class Color {
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

  private final double[] values = new double[4];

  public Color(double r, double g, double b, double a) {
    values[0] = normalize(r);
    values[1] = normalize(g);
    values[2] = normalize(b);
    values[3] = normalize(a);
  }

  public Color(int r, int g, int b, int a) {
    this(normalize(r), normalize(g), normalize(b), normalize(a));
  }

  public Color(byte r, byte g, byte b, byte a) {
    this(normalize(r), normalize(g), normalize(b), normalize(a));
  }

  public Color(double r, double g, double b) {
    this(r, g, b, 1.0);
  }

  public Color(int r, int g, int b) {
    this(r, g, b, Integer.MAX_VALUE);
  }

  public Color(byte r, byte g, byte b) {
    this(r, g, b, Byte.MAX_VALUE);
  }

  public Color(double y) {
    this(y, y, y);
  }

  public Color(int y) {
    this(normalize(y));
  }

  public Color(byte y) {
    this(normalize(y));
  }

  @Override
  public String toString() {
    return "Color(" + r() + ", " + g() + ", " + b() + ", " + a() + ")";
  }

  public double r() {
    return get(0);
  }

  public double g() {
    return get(1);
  }

  public double b() {
    return get(2);
  }

  public double a() {
    return get(3);
  }

  public java.awt.Color toAwtColor() {
    return new java.awt.Color((float)r(), (float)g(), (float)b(), (float)a());
  }

  public double get(int i) {
    return values[i];
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
    values[i] = normalize(value);
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
