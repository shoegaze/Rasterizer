package render.texture;

import render.pixel.PixelGrayscale;

public class TextureGrayscale<N extends Number> extends Texture<N, PixelGrayscale<N>> {
  public TextureGrayscale(Class<N> type, int width, int height) {
    super(type, width, height, 1);
  }

  @Override
  public PixelGrayscale<N> getPixelIndexed(int i, int j) {
    final int k = index2Dto1D(i, j);
    return new PixelGrayscale<>(data.get(k));
  }

  @Override
  public void setPixelIndexed(int i, int j, PixelGrayscale<N> value) {
    data.set(index2Dto1D(i, j), value.k());
  }
}
