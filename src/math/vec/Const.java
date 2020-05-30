package math.vec;

// TODO: Impl. toString()
public class Const<T extends IVector> implements IVectorModifier<T, Const<T>> {
  private final T vec;

  public Const(T src) {
    vec = src;
  }

  public Const(IVectorModifier<T, ?> src) {
    this(src.getVec());
  }

  public Mutable<T> mutate() {
    return new Mutable<>(vec);
  }

  @Override
  public T getVec() {
    return vec;
  }

  @Override
  public Const<T> plus(T rhs) {
    @SuppressWarnings("unchecked")
    T result = (T)vec.copy();

    for (int i = 0; i < vec.getSize(); ++i) {
      result.setElement(
        i,
        vec.getElement(i) + rhs.getElement(i));
    }

    return new Const<>(result);
  }

  @Override
  public Const<T> minus(T rhs) {
    @SuppressWarnings("unchecked")
    T result = (T)vec.copy();

    for (int i = 0; i < vec.getSize(); ++i) {
      result.setElement(
        i,
        vec.getElement(i) - rhs.getElement(i));
    }

    return new Const<>(result);
  }

  @Override
  public Const<T> times(double s) {
    @SuppressWarnings("unchecked")
    T result = (T)vec.copy();

    for (int i = 0; i < vec.getSize(); ++i) {
      result.setElement(
        i,
        vec.getElement(i) * s);
    }
    return new Const<>(result);
  }

  @Override
  public Const<T> divide(double s) {
    return this.times(1/s);
  }

  @Override
  public Const<T> negate() {
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
  public Const<T> cross(Vector3 rhs) {
    if (!(vec instanceof Vector3)) {
      throw new IllegalCallerException();
    }

    Vector3 lhs = (Vector3)vec.copy();
    double x = lhs.y*rhs.z - lhs.z*rhs.y;
    double y = lhs.z*rhs.x - lhs.x*rhs.z;
    double z = lhs.x*rhs.y - lhs.y*rhs.x;

    @SuppressWarnings("unchecked")
    T result = (T)new Vector3(x, y, z);

    return new Const<>(result);
  }
}
