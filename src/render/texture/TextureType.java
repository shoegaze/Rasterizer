package render.texture;

public enum TextureType {
  BYTE(Byte.BYTES),
  INT(Integer.BYTES),
  FLOAT(Float.BYTES),
  DOUBLE(Double.BYTES);

  public static final long BYTE_UNSIGNED_MAX = (long)Byte.MAX_VALUE - Byte.MIN_VALUE;
  public static final long INT_UNSIGNED_MAX = (long)Integer.MAX_VALUE - Integer.MIN_VALUE;

  public final int bytes;

  TextureType(int bytes) {
    this.bytes = bytes;
  }
}
