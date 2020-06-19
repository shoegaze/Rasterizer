package render;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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

  public int width() {
    return width;
  }

  public int height() {
    return height;
  }

  public int channels() {
    return channels;
  }

  public E getPixelUV(double u, double v) {
    return getPixelIndexed((int)u*width, (int)v*height);
  }

  public void setPixelUV(double u, double v, E value) {
    setPixelIndexed((int)u*width, (int)v*height, value);
  }

  @FunctionalInterface
  protected interface TextureMapperIndexed<E> {
    E map(int i, int j, E value);
  }

  public void mapPixelsIndexed(TextureMapperIndexed<E> mapper) {
    for (int i = 0; i < width; ++i) {
      for (int j = 0; j < height; ++j) {
        E result = mapper.map(i, j, getPixelIndexed(i, j));
        setPixelIndexed(i, j, result);
      }
    }
  }

  @FunctionalInterface
  protected interface TextureMapperUV<E> {
    E map(double i, double j, E value);
  }

  public void mapPixelsUV(TextureMapperUV<E> mapper) {
    mapPixelsIndexed((i, j, value) -> mapper.map((double)i/width, (double)j/height, getPixelIndexed(i, j)));
  }

  protected int index2Dto1D(int i, int j) {
    return channels*(j*width + i);
  }
}
