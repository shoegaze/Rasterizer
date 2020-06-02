package math.vec;

import math.IMutate;

public class ConstVector<T extends Vector>
  implements IVectorModifier<T, ConstVector<T>>, IMutate<MutableVector<T>> {

  protected final T vec;

  public ConstVector(T src) {
    vec = src;
  }

  public ConstVector(IVectorModifier<T, ?> src) {
    this(src.getVec());
  }

  @Override
  @SuppressWarnings("unchecked")
  public MutableVector<T> mutate() {
    return new MutableVector<>((T)vec.copy());
  }

  @Override
  public boolean equals(T rhs, double epsilon) {
    return vec.equals(rhs, epsilon);
  }

  @Override
  public String toString() {
    return "Const:" + vec.toString();
  }

  @Override
  public T getVec() {
    return vec;
  }

  @Override
  public ConstVector<T> plus(T rhs) {
    @SuppressWarnings("unchecked")
    T result = (T)vec.copy();

    for (int i = 0; i < vec.getSize(); ++i) {
      result.setElement(
        i, vec.getElement(i) + rhs.getElement(i));
    }

    return new ConstVector<>(result);
  }

  @Override
  public ConstVector<T> minus(T rhs) {
    @SuppressWarnings("unchecked")
    T result = (T)vec.copy();

    for (int i = 0; i < vec.getSize(); ++i) {
      result.setElement(
        i, vec.getElement(i) - rhs.getElement(i));
    }

    return new ConstVector<>(result);
  }

  @Override
  public ConstVector<T> times(double s) {
    @SuppressWarnings("unchecked")
    T result = (T)vec.copy();

    for (int i = 0; i < vec.getSize(); ++i) {
      result.setElement(
        i, vec.getElement(i) * s);
    }
    return new ConstVector<>(result);
  }

  @Override
  public ConstVector<T> divide(double s) {
    return this.times(1/s);
  }

  @Override
  public ConstVector<T> negate() {
    return this.times(-1);
  }

  @Override
  public double dot(T rhs) {
    double sum = 0;
    for (int i = 0; i < vec.getSize(); ++i) {
      sum += vec.getElement(i) * rhs.getElement(i);
    }

    return sum;
  }

  @Override
  public double magnitude_2() {
    return this.dot(vec);
  }

  @Override
  public double magnitude() {
    return Math.sqrt(magnitude_2());
  }

  @Override
  public NormalVector<T> normalized() {
    return new NormalVector<>(
      this.divide(magnitude()).getVec());
  }

  @Override
  public ConstVector<T> cross(Vector3 rhs) {
    // HACK
    if (!(vec instanceof Vector3)) {
      throw new IllegalCallerException();
    }

    Vector3 lhs = (Vector3)vec.copy();
    double x = lhs.y()*rhs.z() - lhs.z()*rhs.y();
    double y = lhs.z()*rhs.x() - lhs.x()*rhs.z();
    double z = lhs.x()*rhs.y() - lhs.y()*rhs.x();

    @SuppressWarnings("unchecked")
    T result = (T)new Vector3(x, y, z);
    return new ConstVector<>(result);
  }
}
