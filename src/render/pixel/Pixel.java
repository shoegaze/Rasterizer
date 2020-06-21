package render.pixel;

// TODO: Rename to Color
public interface Pixel<N extends Number> {
  int channels();
  Pixel<N> copy();
  N get(int i);
  void set(int i, N value);
}
