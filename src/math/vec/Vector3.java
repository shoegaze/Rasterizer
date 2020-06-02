package math.vec;

public final class Vector3 extends Vector {
  public static final ConstVector<Vector3> ZERO = new ConstVector<>(new Vector3(0, 0, 0));
  public static final ConstVector<Vector3> ONES = new ConstVector<>(new Vector3(1, 1, 1));
  public static final ConstVector<Vector3> RIGHT = new ConstVector<>(new Vector3(1, 0, 0));
  public static final ConstVector<Vector3> LEFT = new ConstVector<>(new Vector3(-1, 0, 0));
  public static final ConstVector<Vector3> UP = new ConstVector<>(new Vector3(0, 1, 0));
  public static final ConstVector<Vector3> DOWN = new ConstVector<>(new Vector3(0, -1, 0));
  public static final ConstVector<Vector3> FORWARD = new ConstVector<>(new Vector3(0, 0, 1));
  public static final ConstVector<Vector3> BACKWARD = new ConstVector<>(new Vector3(0, 0, -1));


  public Vector3(double x, double y, double z) {
    super(x, y, z);
  }

  public double x() {
    return getElement(0);
  }

  public double y() {
    return getElement(1);
  }

  public double z() {
    return getElement(2);
  }

  @Override
  public Vector3 copy() {
    return new Vector3(
      getElement(0),
      getElement(1),
      getElement(2));
  }

  @Override
  public int getSize() {
    return 3;
  }
}
