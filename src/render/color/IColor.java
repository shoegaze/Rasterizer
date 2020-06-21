package render.color;

public interface IColor<N extends Number> {
  int channels();
  IColor<N> copy();
  N get(int i);
  void set(int i, N value);
}
