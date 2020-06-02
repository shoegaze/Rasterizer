package math.vec;

public final class Mutable<T extends Vector> implements IVectorModifier<T, Mutable<T>> {
  private T vec;

  @SuppressWarnings("unchecked")
  public Mutable(T src) {
    vec = (T)src.copy();
  }

  public Mutable(IVectorModifier<T, ?> src) {
    this(src.getVec());
  }

  public Const<T> freeze() {
    return new Const<>(vec);
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
  public Mutable<T> plus(T rhs) {
    for (int i = 0; i < vec.getSize(); ++i) {
      vec.setElement(
        i, vec.getElement(i) + rhs.getElement(i));
    }

    return this;
  }

  @Override
  public Mutable<T> minus(T rhs) {
    for (int i = 0; i < vec.getSize(); ++i) {
      vec.setElement(
        i, vec.getElement(i) - rhs.getElement(i));
    }

    return this;
  }

  @Override
  public Mutable<T> times(double s) {
    for (int i = 0; i < vec.getSize(); ++i) {
      vec.setElement(
        i, vec.getElement(i) * s);
    }
    return this;
  }

  @Override
  public Mutable<T> divide(double s) {
    return this.times(1/s);
  }

  @Override
  public Mutable<T> negate() {
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
  public Normal<T> normalized() {
    return new Normal<>(
      this.divide(magnitude()).getVec());
  }

  @Override
  public Mutable<T> cross(Vector3 rhs) {
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
