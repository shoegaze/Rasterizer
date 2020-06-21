package render.texture;

import render.color.ColorGray;

public class TextureGrayscale<N extends Number> extends Texture<N, ColorGray<N>> {
  public TextureGrayscale(Class<N> type, int width, int height) {
    super(type, width, height, 1);
  }

  @Override
  public ColorGray<N> getPixelIndexed(int i, int j) {
    final int k = index2Dto1D(i, j);
    return new ColorGray<>(data.get(k));
  }

  @Override
  public void setPixelIndexed(int i, int j, ColorGray<N> value) {
    data.set(index2Dto1D(i, j), value.k());
  }
}
