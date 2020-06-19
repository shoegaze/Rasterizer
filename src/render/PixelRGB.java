package render;

import java.util.ArrayList;
import java.util.List;

public final class PixelRGB<E extends Number> implements Pixel<E> {
  private final List<E> data;

  public PixelRGB(E r, E g, E b) {
    this.data = new ArrayList<>(3);
    data.add(r);
    data.add(g);
    data.add(b);
  }

  @Override
  public String toString() {
    return "rgb" + data.toString()
      .replace("[", "(")
      .replace("]", ")");
  }

  @Override
  public int channels() {
    return 3;
  }

  @Override
  public PixelRGB<E> copy() {
    return new PixelRGB<>(r(), g(), b());
  }

  @Override
  public E get(int i) {
    return data.get(i);
  }

  @Override
  public void set(int i, E value) {
    data.set(i, value);
  }

  public E r() {
    return get(0);
  }

  public E g() {
    return get(1);
  }

  public E b() {
    return get(2);
  }
}
