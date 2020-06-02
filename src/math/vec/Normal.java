package math.vec;

// TODO: Impl. toString()
public final class Normal<T extends Vector> extends Const<T> {
  public static <T extends Vector> Normal<T> from(T src) {
    return new Const<T>(src).normalized();
  }

  protected Normal(T src) {
    super(src);
  }

  protected Normal(IVectorModifier<T, ?> src) {
    super(src);
  }

  @Override
  public String toString() {
    return "Normal:" + vec.toString();
  }

  @Override
  public double magnitude_2() {
    return 1;
  }

  @Override
  public Normal<T> normalized() {
    return this;
  }
}
