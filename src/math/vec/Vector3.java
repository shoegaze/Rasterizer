package math.vec;

public final class Vector3 implements IVector {
  public static final Const<Vector3> ZERO = new Const<>(new Vector3(0, 0, 0));
  public static final Const<Vector3> ONES = new Const<>(new Vector3(1, 1, 1));
  public static final Const<Vector3> RIGHT = new Const<>(new Vector3(1, 0, 0));
  public static final Const<Vector3> LEFT = new Const<>(new Vector3(-1, 0, 0));
  public static final Const<Vector3> UP = new Const<>(new Vector3(0, 1, 0));
  public static final Const<Vector3> DOWN = new Const<>(new Vector3(0, -1, 0));
  public static final Const<Vector3> FORWARD = new Const<>(new Vector3(0, 0, 1));
  public static final Const<Vector3> BACKWARD = new Const<>(new Vector3(0, 0, -1));


  public double x;
  public double y;
  public double z;

  public Vector3(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  @Override
  public boolean equals(IVector rhs, double epsilon) {
    if (!(rhs instanceof Vector3)) {
      return false;
    }

    Vector3 v = (Vector3)rhs;
    return Math.abs(x - v.x) <= epsilon &&
           Math.abs(y - v.y) <= epsilon &&
           Math.abs(z - v.z) <= epsilon;
  }

  @Override
  public String toString() {
    return "("+x+", "+y+", "+z+")";
  }

  @Override
  public Vector3 copy() {
    return new Vector3(x, y, z);
  }

  @Override
  public int getSize() {
    return 3;
  }

  @Override
  public double getElement(int i) {
    switch (i) {
      case 0: return x;
      case 1: return y;
      case 2: return z;
      default: throw new IllegalArgumentException();
    }
  }

  @Override
  public void setElement(int i, double v) {
    switch (i) {
      case 0: x = v; return;
      case 1: y = v; return;
      case 2: z = v; return;
      default: throw new IllegalArgumentException();
    }
  }
}
