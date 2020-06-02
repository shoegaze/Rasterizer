package math.vec;

import math.IFreeze;

public final class MutableVector<T extends Vector>
  implements IVectorModifier<T, MutableVector<T>>, IFreeze<ConstVector<T>> {

  private T vec;

  public MutableVector(T src) {
    vec = src;
  }

  public MutableVector(IVectorModifier<T, ?> src) {
    this(src.getVec());
  }

  @Override
  public ConstVector<T> freeze() {
    return new ConstVector<>(vec);
  }

  @Override
  public boolean equals(T rhs, double epsilon) {
    return vec.equals(rhs, epsilon);
  }

  @Override
  public String toString() {
    return "Mutable:" + vec.toString();
  }

  @Override
  public T getVec() {
    return vec;
  }

  @Override
  public MutableVector<T> plus(T rhs) {
    for (int i = 0; i < vec.getSize(); ++i) {
      vec.setElement(
        i, vec.getElement(i) + rhs.getElement(i));
    }

    return this;
  }

  @Override
  public MutableVector<T> minus(T rhs) {
    for (int i = 0; i < vec.getSize(); ++i) {
      vec.setElement(
        i, vec.getElement(i) - rhs.getElement(i));
    }

    return this;
  }

  @Override
  public MutableVector<T> times(double s) {
    for (int i = 0; i < vec.getSize(); ++i) {
      vec.setElement(
        i, vec.getElement(i) * s);
    }
    return this;
  }

  @Override
  public MutableVector<T> divide(double s) {
    return this.times(1/s);
  }

  @Override
  public MutableVector<T> negate() {
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
  public MutableVector<T> cross(Vector3 rhs) {
    if (!(vec instanceof Vector3)) {
      throw new IllegalCallerException();
    }

    Vector3 lhs = (Vector3)vec;
    double x = lhs.y()*rhs.z() - lhs.z()*rhs.y();
    double y = lhs.z()*rhs.x() - lhs.x()*rhs.z();
    double z = lhs.x()*rhs.y() - lhs.y()*rhs.x();

    lhs.setElement(0, x);
    lhs.setElement(1, y);
    lhs.setElement(2, z);

    return this;
  }
}
