package math.vec;

// TODO: Impl. toString()
public final class Normal<T extends IVector> extends Const<T> {
  public static <T extends IVector> Normal<T> from(T src) {
    return new Const<T>(src).normalized();
  }

  protected Normal(T src) {
    super(src);
  }

  protected Normal(IVectorModifier<T, ?> src) {
    super(src);
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
