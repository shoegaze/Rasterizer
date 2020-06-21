package render.texture;

import java.util.ArrayList;
import java.util.List;
import render.pixel.Pixel;

public abstract class Texture<N extends Number, E extends Pixel<?>> {
  private static <N extends Number> N zero(Class<N> type) {
    if (Float.class.equals(type)) {
      return type.cast(0f);
    }

    if (Double.class.equals(type)) {
      return type.cast(0.0);
    }

    if (Integer.class.equals(type)) {
      return type.cast(0);
    }

    if (Byte.class.equals(type)) {
      return type.cast((byte)0);
    }

    if (Short.class.equals(type)) {
      return type.cast((short)0);
    }

    if (Long.class.equals(type)) {
      return type.cast((long)0);
    }

    throw new IllegalArgumentException(type.toString() + " cannot be used in a Texture class.");
  }

  protected final Class<N> type;
  protected final List<N> data;
  private final int width;
  private final int height;
  private final int channels;

  public Texture(Class<N> type, int width, int height, int channels) {
    this.type = type;
    this.width = width;
    this.height = height;
    this.channels = channels;
    this.data = new ArrayList<>(width*height*channels);

    // TODO: Use object pooling to reuse memory chunks
    for (int i = 0; i < size(); ++i) {
      this.data.add(zero(type));
    }
  }

  public abstract E getPixelIndexed(int i, int j);
  public abstract void setPixelIndexed(int i, int j, E value);

  public int size() {
    return width*height*channels;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getChannels() {
    return channels;
  }

  public E getPixelUV(double u, double v) {
    return getPixelIndexed((int)(u*width), (int)(v*height));
  }

  public void setPixelUV(double u, double v, E value) {
    setPixelIndexed((int)(u*width), (int)(v*height), value);
  }

  @FunctionalInterface
  public interface TextureMapperIndexed<E> {
    E map(int i, int j, E value);
  }

  public void mapPixelsIndexed(TextureMapperIndexed<E> mapper) {
    for (int j = 0; j < height; ++j) {
      for (int i = 0; i < width; ++i) {
        E result = mapper.map(i, j, getPixelIndexed(i, j));
        setPixelIndexed(i, j, result);
      }
    }
  }

  @FunctionalInterface
  public interface TextureMapperUV<E> {
    E map(double i, double j, E value);
  }

  public void mapPixelsUV(TextureMapperUV<E> mapper) {
    final double w_1 = 1.0 / width;
    final double h_1 = 1.0 / height;
    mapPixelsIndexed((i, j, value) -> mapper.map(
      w_1*((double)i + 0.5),
      h_1*((double)j + 0.5),
      getPixelIndexed(i, j)));
  }

  public void blit(Texture<N, E> dest, TextureRegion from, TextureRegion to) {
    throw new UnsupportedOperationException();
  }

  protected int index2Dto1D(int i, int j) {
    return channels*(i*height + j);
  }
}
