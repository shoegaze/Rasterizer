package math.matrix;

import math.vec.Vector;

public final class ConstMatrix<T extends SquareMatrix<?>> implements IMatrixModifier<T, ConstMatrix<T>> {
  private T mat;

  public ConstMatrix(T src) {
    mat = src;
  }

  public ConstMatrix(IMatrixModifier<T,?> src) {
    mat = src.getMatrix();
  }

  @Override
  public String toString() {
    return "Const:" + mat.toString();
  }

  @Override
  public T getMatrix() {
    return mat;
  }

  @Override
  public ConstMatrix<T> plus(T rhs) {
    @SuppressWarnings("unchecked")
    T result = (T)mat.copy();

    for (int i = 0; i < mat.getSize(); ++i) {
      for (int j = 0; j < mat.getSize(); ++j) {
        double l = mat.getElement(i, j);
        double r = rhs.getElement(i, j);
        result.setElement(i, j, l+r);
      }
    }

    return new ConstMatrix<>(result);
  }

  @Override
  public ConstMatrix<T> minus(T rhs) {
    @SuppressWarnings("unchecked")
    T result = (T)mat.copy();

    for (int i = 0; i < mat.getSize(); ++i) {
      for (int j = 0; j < mat.getSize(); ++j) {
        double l = mat.getElement(i, j);
        double r = rhs.getElement(i, j);
        result.setElement(i, j, l-r);
      }
    }

    return new ConstMatrix<>(result);
  }

  @Override
  public ConstMatrix<T> times(double s) {
    @SuppressWarnings("unchecked")
    T result = (T)mat.copy();

    for (int i = 0; i < mat.getSize(); ++i) {
      for (int j = 0; j < mat.getSize(); ++j) {
        double l = mat.getElement(i, j);
        result.setElement(i, j, l*s);
      }
    }

    return new ConstMatrix<>(result);
  }

  @Override
  public ConstMatrix<T> divide(double s) {
    return times(1/s);
  }

  @Override
  public ConstMatrix<T> dot(T rhs) {
    @SuppressWarnings("unchecked")
    T result = (T)mat.copy();

    for (int i = 0; i < mat.getSize(); ++i) {
      for (int j = 0; j < mat.getSize(); ++j) {
        Vector l = mat.getRow(i);
        Vector r = rhs.getCol(j);
        result.setElement(i, j, new math.vec.ConstVector<>(l).dot(r));
      }
    }

    return new ConstMatrix<>(result);
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
