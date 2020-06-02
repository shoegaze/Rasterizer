package math.matrix;

import math.vec.Vector;

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
    @SuppressWarnings("unchecked")
    T result = (T)mat.copy();

    for (int i = 0; i < mat.getSize(); ++i) {
      for (int j = 0; j < mat.getSize(); ++j) {
        double l = mat.getElement(i, j);
        double r = rhs.getElement(i, j);
        result.setElement(i, j, l+r);
      }
    }

    return new Const<>(result);
  }

  @Override
  public Const<T> minus(T rhs) {
    @SuppressWarnings("unchecked")
    T result = (T)mat.copy();

    for (int i = 0; i < mat.getSize(); ++i) {
      for (int j = 0; j < mat.getSize(); ++j) {
        double l = mat.getElement(i, j);
        double r = rhs.getElement(i, j);
        result.setElement(i, j, l-r);
      }
    }

    return new Const<>(result);
  }

  @Override
  public Const<T> times(double s) {
    @SuppressWarnings("unchecked")
    T result = (T)mat.copy();

    for (int i = 0; i < mat.getSize(); ++i) {
      for (int j = 0; j < mat.getSize(); ++j) {
        double l = mat.getElement(i, j);
        result.setElement(i, j, l*s);
      }
    }

    return new Const<>(result);
  }

  @Override
  public Const<T> divide(double s) {
    return times(1/s);
  }

  @Override
  public Const<T> dot(T rhs) {
    @SuppressWarnings("unchecked")
    T result = (T)mat.copy();

    for (int i = 0; i < mat.getSize(); ++i) {
      for (int j = 0; j < mat.getSize(); ++j) {
        Vector l = mat.getRow(i);
        Vector r = rhs.getCol(j);
        result.setElement(i, j, new math.vec.Const<>(l).dot(r));
      }
    }

    return new Const<>(result);
  }

  // @Override
  // public Const<T> invert() {
  //   T result = (T)mat.copy();
  //   return new Const<>(result);
  // }

  @Override
  public double det() {
    return mat.det();
  }
}
