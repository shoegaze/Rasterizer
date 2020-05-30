package math.matrix;

public final class Mutable<T extends ISquareMatrix<?>> implements IMatrixModifier<T, Mutable<T>> {
  private T mat;

  @SuppressWarnings("unchecked")
  public Mutable(T src) {
    mat = (T)src.copy();
  }

  public Mutable(IMatrixModifier<T, ?> src) {
    this(src.getMatrix());
  }

  @Override
  public T getMatrix() {
    return mat;
  }

  @Override
  public Mutable<T> plus(T rhs) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Mutable<T> minus(T rhs) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Mutable<T> times(double s) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Mutable<T> divide(double s) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Mutable<T> dot(T rhs) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Mutable<T> invert() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public double det() {
    return mat.det();
  }
}
