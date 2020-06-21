package render.color;

public final class ColorGray<N extends Number> implements IColor<N> {
  N data;

  public ColorGray(N value) {
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
  public ColorGray<N> copy() {
    return new ColorGray<>(k());
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
