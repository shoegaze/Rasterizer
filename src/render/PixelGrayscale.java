package render;

public final class PixelGrayscale<N extends Number> implements Pixel<N> {
  N data;

  public PixelGrayscale(N value) {
    this.data = value;
  }

  @Override
  public String toString() {
    return "gray(" + data + ")";
  }

  @Override
  public int channels() {
    return 1;
  }

  @Override
  public PixelGrayscale<N> copy() {
    return new PixelGrayscale<>(k());
  }

  @Override
  public N get(int i) {
    if (i == 0) {
      return data;
    }

    throw new IndexOutOfBoundsException();
  }

  @Override
  public void set(int i, N value) {
    if (i == 0) {
      data = value;
    }

    throw new IndexOutOfBoundsException();
  }

  public N k() {
    return get(0);
  }
}
