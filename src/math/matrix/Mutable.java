package math.matrix;

public final class Mutable<T extends SquareMatrix<?>> implements IMatrixModifier<T, Mutable<T>> {
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
    for (int i = 0; i < mat.getSize(); ++i) {
      for (int j = 0; j < mat.getSize(); ++j) {
        double l = mat.getElement(i, j);
        double r = rhs.getElement(i, j);
        mat.setElement(i, j, l+r);
      }
    }

    return this;
  }

  @Override
  public Mutable<T> minus(T rhs) {
    for (int i = 0; i < mat.getSize(); ++i) {
      for (int j = 0; j < mat.getSize(); ++j) {
        double l = mat.getElement(i, j);
        double r = rhs.getElement(i, j);
        mat.setElement(i, j, l-r);
      }
    }

    return this;
  }

  @Override
  public Mutable<T> times(double s) {
    for (int i = 0; i < mat.getSize(); ++i) {
      for (int j = 0; j < mat.getSize(); ++j) {
        double l = mat.getElement(i, j);
        mat.setElement(i, j, l*s);
      }
    }

    return this;
  }

  @Override
  public Mutable<T> divide(double s) {
    return times(1/s);
  }

  @Override
  public Mutable<T> dot(T rhs) {
    mat = new Const<>(mat)
      .dot(rhs)
      .getMatrix();

    return this;
  }

  // @Override
  // public Mutable<T> invert() {
  //   // TODO Auto-generated method stub
  //   return null;
  // }

  @Override
  public double det() {
    return mat.det();
  }
}
