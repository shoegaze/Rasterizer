package math.vec;

public final class Vector4 extends Vector {
  public static final Const<Vector4> ZERO = new Const<>(new Vector4(0, 0, 0, 0));
  public static final Const<Vector4> ONES = new Const<>(new Vector4(1, 1, 1, 1));
  public static final Const<Vector4> RIGHT = new Const<>(new Vector4(1, 0, 0, 0));
  public static final Const<Vector4> LEFT = new Const<>(new Vector4(-1, 0, 0, 0));
  public static final Const<Vector4> UP = new Const<>(new Vector4(0, 1, 0, 0));
  public static final Const<Vector4> DOWN = new Const<>(new Vector4(0, -1, 0, 0));
  public static final Const<Vector4> FORWARD = new Const<>(new Vector4(0, 0, 1, 0));
  public static final Const<Vector4> BACKWARD = new Const<>(new Vector4(0, 0, -1, 0));
  public static final Const<Vector4> POSITIVE_W = new Const<>(new Vector4(0, 0, 0, 1));
  public static final Const<Vector4> NEGATIVE_W = new Const<>(new Vector4(0, 0, 0, -1));


  public Vector4(double x, double y, double z, double w) {
    super(x, y, z, w);
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

  public double w() {
    return getElement(3);
  }

  @Override
  public Vector4 copy() {
    return new Vector4(
      getElement(0),
      getElement(1),
      getElement(2),
      getElement(3));
  }

  @Override
  public int getSize() {
    return 4;
  }
}
