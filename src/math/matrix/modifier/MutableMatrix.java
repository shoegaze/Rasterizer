package math.matrix.modifier;

import math.matrix.SquareMatrix;
import math.modifier.Const;
import math.modifier.IFreeze;

public final class MutableMatrix<T extends SquareMatrix<?>>
  implements IMatrixModifier<T, MutableMatrix<T>>, IFreeze<ConstMatrix<T>> {

  // NOTE: There is no guarantee this Matrix reference is constant.
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
  public boolean equals(T rhs, double epsilon) {
    return mat.equals(rhs, epsilon);
  }

  @Override
  public boolean equals(MutableMatrix<T> rhs, double epsilon) {
    return equals(rhs.mat, epsilon);
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
    mat.map((i, j, l) -> l+rhs.getElement(i, j));

    return this;
  }

  @Override
  public MutableMatrix<T> plus(MutableMatrix<T> rhs) {
    return plus(rhs.mat);
  }

  @Override
  public MutableMatrix<T> minus(T rhs) {
    mat.map((i, j, l) -> l-rhs.getElement(i, j));

    return this;
  }

  @Override
  public MutableMatrix<T> minus(MutableMatrix<T> rhs) {
    return minus(rhs.mat);
  }

  @Override
  public MutableMatrix<T> times(double s) {
    mat.map((i, j, l) -> l*s);

    return this;
  }

  @Override
  public MutableMatrix<T> divide(double s) {
    return times(1/s);
  }

  @Override
  public MutableMatrix<T> dot(T rhs) {
    // HACK
    mat = Const.of(mat)
      .dot(rhs)
      .getMatrix();

    return this;
  }

  @Override
  public MutableMatrix<T> dot(MutableMatrix<T> rhs) {
    return dot(rhs.mat);
  }

  @Override
  public MutableMatrix<T> dotLeft(T lhs) {
    // HACK
    mat = Const.of(lhs)
        .dot(mat)
        .getMatrix();

    return this;
  }

  @Override
  public MutableMatrix<T> dotLeft(MutableMatrix<T> lhs) {
    return dotLeft(lhs.mat);
  }

  @Override
  public MutableMatrix<T> transpose() {
    mat.transpose();

    return this;
  }

  @Override
  public double det() {
    return mat.det();
  }
}
