package math.vec;

public final class Vector4 implements IVector {
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


  public double x;
  public double y;
  public double z;
  public double w;

  public Vector4(double x, double y, double z, double w) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.w = w;
  }

  @Override
  public boolean equals(IVector rhs, double epsilon) {
    if (!(rhs instanceof Vector4)) {
      return false;
    }

    Vector4 v = (Vector4)rhs;
    return Math.abs(x - v.x) <= epsilon &&
           Math.abs(y - v.y) <= epsilon &&
           Math.abs(z - v.z) <= epsilon &&
           Math.abs(w - v.w) <= epsilon;
  }

  @Override
  public String toString() {
    return "("+x+", "+y+", "+z+", "+w+")";
  }

  @Override
  public Vector4 copy() {
    return new Vector4(x, y, z, w);
  }

  @Override
  public int getSize() {
    return 4;
  }

  @Override
  public double getElement(int i) {
    switch (i) {
      case 0: return x;
      case 1: return y;
      case 2: return z;
      case 3: return w;
      default: throw new IllegalArgumentException();
    }
  }

  @Override
  public void setElement(int i, double v) {
    switch (i) {
      case 0: x = v; return;
      case 1: y = v; return;
      case 2: z = v; return;
      case 3: w = v; return;
      default: throw new IllegalArgumentException();
    }
  }
}