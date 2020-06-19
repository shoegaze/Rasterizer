package render;

public class TextureRGB<N extends Number> extends Texture<N, PixelRGB<N>> {
  public TextureRGB(Class<N> type, int width, int height) {
    super(type, width, height, 3);
  }

  @Override
  public PixelRGB<N> getPixelIndexed(int i, int j) {
    final int k = index2Dto1D(i, j);
    return new PixelRGB<>(
        data.get(k+0),
        data.get(k+1),
        data.get(k+2));
  }

  @Override
  public void setPixelIndexed(int i, int j, PixelRGB<N> value) {
    final int k = index2Dto1D(i, j);
    for (int ii = 0; ii < channels(); ++ii) {
      data.set(k+ii, value.get(ii));
    }
  }
}
