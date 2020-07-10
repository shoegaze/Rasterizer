package math.vector.modifier;

import math.modifier.IFreeze;
import math.vector.Vector;
import math.vector.Vector3;

public final class MutableVector<T extends Vector>
  implements IVectorModifier<T, MutableVector<T>>, IFreeze<ConstVector<T>> {

  // NOTE: There is no guarantee this Vector reference is constant.
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
  public boolean equals(MutableVector<T> rhs, double epsilon) {
    return equals(rhs.vec, epsilon);
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
  public MutableVector<T> plus(MutableVector<T> rhs) {
    return plus(rhs.vec);
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
  public MutableVector<T> minus(MutableVector<T> rhs) {
    return minus(rhs.vec);
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
  public double dot(MutableVector<T> rhs) {
    return dot(rhs.vec);
  }

  @Override
  public double length_2() {
    return this.dot(vec);
  }

  @Override
  public double length() {
    return Math.sqrt(length_2());
  }

  @Override
  public NormalVector<T> normalized() {
    return new NormalVector<>(
      this.divide(length()).getVec());
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

  @Override
  public MutableVector<T> cross(IVectorModifier<Vector3, ?> rhs) {
    return cross(rhs);
  }
}
