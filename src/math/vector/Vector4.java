package math.vector;

import math.vector.modifier.ConstVector;

public class Vector4 extends Vector {
  public static final ConstVector<Vector4> ZERO = new ConstVector<>(new Vector4(0, 0, 0, 0));
  public static final ConstVector<Vector4> ONES = new ConstVector<>(new Vector4(1, 1, 1, 1));
  public static final ConstVector<Vector4> RIGHT = new ConstVector<>(new Vector4(1, 0, 0, 0));
  public static final ConstVector<Vector4> LEFT = new ConstVector<>(new Vector4(-1, 0, 0, 0));
  public static final ConstVector<Vector4> UP = new ConstVector<>(new Vector4(0, 1, 0, 0));
  public static final ConstVector<Vector4> DOWN = new ConstVector<>(new Vector4(0, -1, 0, 0));
  public static final ConstVector<Vector4> FORWARD = new ConstVector<>(new Vector4(0, 0, 1, 0));
  public static final ConstVector<Vector4> BACKWARD = new ConstVector<>(new Vector4(0, 0, -1, 0));
  public static final ConstVector<Vector4> POSITIVE_W = new ConstVector<>(new Vector4(0, 0, 0, 1));
  public static final ConstVector<Vector4> NEGATIVE_W = new ConstVector<>(new Vector4(0, 0, 0, -1));


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
