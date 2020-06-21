package render.pixel;

import java.util.ArrayList;
import java.util.List;

public final class PixelRGBA<E extends Number> implements Pixel<E> {
  private final List<E> data;

  public PixelRGBA(E r, E g, E b, E a) {
    this.data = new ArrayList<>(4);
    data.add(r);
    data.add(g);
    data.add(b);
    data.add(a);
  }

  @Override
  public String toString() {
    return "rgba" + data.toString()
      .replace("[", "(")
      .replace("]", ")");
  }

  @Override
  public int channels() {
    return 4;
  }

  @Override
  public PixelRGBA<E> copy() {
    return new PixelRGBA<>(r(), g(), b(), a());
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

  public E a() {
    return get(3);
  }
}
