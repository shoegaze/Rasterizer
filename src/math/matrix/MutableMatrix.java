package math.matrix;

import math.IFreeze;

public final class MutableMatrix<T extends SquareMatrix<?>>
  implements IMatrixModifier<T, MutableMatrix<T>>, IFreeze<ConstMatrix<T>> {

  private T mat;

  @SuppressWarnings("unchecked")
  public MutableMatrix(T src) {
    mat = (T)src.copy();
  }

  public MutableMatrix(IMatrixModifier<T, ?> src) {
    this(src.getMatrix());
  }

  @Override
  public ConstMatrix<T> freeze() {
    return new ConstMatrix<>(mat);
  }

  @Override
  public String toString() {
    return "Mutable:" + mat.toString();
  }

  @Override
  public T getMatrix() {
    return mat;
  }

  @Override
  public MutableMatrix<T> plus(T rhs) {
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
  public MutableMatrix<T> minus(T rhs) {
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
  public MutableMatrix<T> times(double s) {
    for (int i = 0; i < mat.getSize(); ++i) {
      for (int j = 0; j < mat.getSize(); ++j) {
        double l = mat.getElement(i, j);
        mat.setElement(i, j, l*s);
      }
    }

    return this;
  }

  @Override
  public MutableMatrix<T> divide(double s) {
    return times(1/s);
  }

  @Override
  public MutableMatrix<T> dot(T rhs) {
    mat = new ConstMatrix<>(mat)
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
