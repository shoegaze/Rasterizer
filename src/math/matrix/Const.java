package math.matrix;

public final class Const<T extends ISquareMatrix<?>> implements IMatrixModifier<T, Const<T>> {
  private T mat;

  public Const(T src) {
    mat = src;
  }

  public Const(IMatrixModifier<T,?> src) {
    mat = src.getMatrix();
  }

  @Override
  public T getMatrix() {
    return mat;
  }

  @Override
  public Const<T> plus(T rhs) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Const<T> minus(T rhs) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Const<T> times(double s) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Const<T> divide(double s) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Const<T> dot(T rhs) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Const<T> invert() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public double det() {
    return mat.det();
  }
}
