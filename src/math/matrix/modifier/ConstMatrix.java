package math.matrix.modifier;

import math.matrix.SquareMatrix;
import math.modifier.IMutate;
import math.vector.Vector;
import math.vector.modifier.ConstVector;

public final class ConstMatrix<T extends SquareMatrix<?>>
  implements IMatrixModifier<T, ConstMatrix<T>>, IMutate<MutableMatrix<T>> {

  private T mat;

  public ConstMatrix(T src) {
    mat = src;
  }

  public ConstMatrix(IMatrixModifier<T,?> src) {
    mat = src.getMatrix();
  }

  @Override
  @SuppressWarnings("unchecked")
  public MutableMatrix<T> mutate() {
    return new MutableMatrix<>((T)mat.copy());
  }

  @Override
  public boolean equals(T rhs, double epsilon) {
    return mat.equals(rhs, epsilon);
  }

  @Override
  public boolean equals(ConstMatrix<T> rhs, double epsilon) {
    return equals(rhs.mat, epsilon);
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
  public ConstMatrix<T> plus(ConstMatrix<T> rhs) {
    return plus(rhs.mat);
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
  public ConstMatrix<T> minus(ConstMatrix<T> rhs) {
    return minus(rhs.mat);
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
        result.setElement(i, j, new ConstVector<>(l).dot(r));
      }
    }

    return new ConstMatrix<>(result);
  }

  @Override
  public ConstMatrix<T> dot(ConstMatrix<T> rhs) {
    return dot(rhs.mat);
  }

  @Override
  public ConstMatrix<T> transpose() {
    @SuppressWarnings("unchecked")
    T result = (T)mat.copy();
    result.transpose();

    return new ConstMatrix<>(result);
  }

  @Override
  public double det() {
    return mat.det();
  }
}
