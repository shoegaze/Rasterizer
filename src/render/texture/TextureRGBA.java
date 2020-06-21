package render.texture;

import render.color.ColorRGBA;

public class TextureRGBA<N extends Number> extends Texture<N, ColorRGBA<N>> {
  public TextureRGBA(Class<N> type, int width, int height) {
    super(type, width, height, 4);
  }

  @Override
  public ColorRGBA<N> getPixelIndexed(int i, int j) {
    final int k = index2Dto1D(i, j);
    return new ColorRGBA<>(
        data.get(k+0),
        data.get(k+1),
        data.get(k+2),
        data.get(k+3));
  }

  @Override
  public void setPixelIndexed(int i, int j, ColorRGBA<N> value) {
    final int k = index2Dto1D(i, j);
    for (int ii = 0; ii < channels(); ++ii) {
      data.set(k+ii, value.get(ii));
    }
  }
}
