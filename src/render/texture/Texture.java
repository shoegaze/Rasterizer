package render.texture;

import jdk.swing.interop.SwingInterOpUtils;

import java.nio.ByteBuffer;

// Image data container with origin at bottom-left
public class Texture {
  @FunctionalInterface
  public interface TextureMapIndexed {
    Color map(final int x, final int y, Color color);
  }

  @FunctionalInterface
  public interface TextureMapUv {
    Color map(final double u, final double v, Color color);
  }

  @FunctionalInterface
  public interface TextureForeachIndexed {
    void each(final int x, final int y, Color color);
  }

  @FunctionalInterface
  public interface TextureForeachUv {
    void each(final double u, final double v, Color color);
  }


  private final TextureType type;
  private final ByteBuffer buffer;
  private final int width;
  private final int height;
  private final int channels;

  public Texture(TextureType type, int width, int height, int channels) {
    this.type = type;
    this.width = width;
    this.height = height;
    // TODO: Support channels > 4 or enforce channels <= 3
    this.channels = channels;
    // TODO: Use object pooling to reuse memory chunks
    this.buffer = ByteBuffer.allocate(size());
  }

  public TextureType type() {
    return type;
  }

  public int size() {
    return width * height * channels * type.bytes;
  }

  public int width() {
    return width;
  }

  public int height() {
    return height;
  }

  public int channels() {
    return channels;
  }

  private int index2Dto1D(int i, int j) {
    return channels*type.bytes * (j*width + i);
  }

  private Color getBufferColor(int i) {
    Color color = new Color(0);

    for (int c = 0; c < channels; ++c) {
      final int b = i + c*type.bytes;

      switch (type) {
        case BYTE -> color.set(c, buffer.get(b));
        case INT -> color.set(c, buffer.getInt(b));
        case FLOAT -> color.set(c, buffer.getFloat(b));
        case DOUBLE -> color.set(c, buffer.getDouble(b));
      }
    }

    return color;
  }

  private void putBufferColor(int i, Color color) {
    for (int c = 0; c < channels; ++c) {
      final int b = i + c*type.bytes;

      switch (type) {
        case BYTE -> buffer.put(b, color.getByte(c));
        case INT -> buffer.putInt(b, color.getInt(c));
        case FLOAT -> buffer.putFloat(b, color.getFloat(c));
        case DOUBLE -> buffer.putDouble(b, color.get(c));
      }
    }
  }

  public Color getColor(int x, int y) {
    return getBufferColor(index2Dto1D(x, height-1 - y));
  }

  public void setColor(int x, int y, Color color) {
    putBufferColor(index2Dto1D(x, y), color);
  }

  public Color getColor(double u, double v) {
    return getColor((int)(u*width), (int)(v*height));
  }

  public void setColor(double u, double v, Color color) {
    setColor((int)(u*width), (int)(v*height), color);
  }

  public void foreach(TextureForeachIndexed process) {
    for (int y = 0; y < height; ++y) {
      for (int x = 0; x < width; ++x) {
        process.each(x, y, getColor(x, y));
      }
    }
  }

  public void foreach(TextureForeachUv process) {
    foreach((int x, int y, Color color) ->
        process.each((x+0.5) / width, (y+0.5) / height, color));
  }

  public void map(TextureMapIndexed mapper) {
    foreach((int x, int y, Color color) ->
        setColor(x, y, mapper.map(x, y, color)));
  }

  public void map(TextureMapUv mapper) {
    foreach((double u, double v, Color color) ->
        setColor(u, v, mapper.map(u, v, color)));
  }
}
