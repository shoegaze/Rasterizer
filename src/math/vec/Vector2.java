package math.vec;

public final class Vector2 implements IVector {
  public static final Const<Vector2> ZERO = new Const<>(new Vector2(0, 0));
  public static final Const<Vector2> ONES = new Const<>(new Vector2(1, 1));
  public static final Const<Vector2> RIGHT = new Const<>(new Vector2(1, 0));
  public static final Const<Vector2> LEFT = new Const<>(new Vector2(-1, 0));
  public static final Const<Vector2> UP = new Const<>(new Vector2(0, 1));
  public static final Const<Vector2> DOWN = new Const<>(new Vector2(0, -1));


  public double x;
  public double y;

  public Vector2(double x, double y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(IVector rhs, double epsilon) {
    if (!(rhs instanceof Vector2)) {
      return false;
    }

    final Vector2 v = (Vector2)rhs;
    return Math.abs(x - v.x) <= epsilon &&
           Math.abs(y - v.y) <= epsilon;
  }

  @Override
  public String toString() {
    return "("+x+", "+y+")";
  }

  @Override
  public Vector2 copy() {
    return new Vector2(x, y);
  }

  @Override
  public int getSize() {
    return 2;
  }

  @Override
  public double getElement(int i) {
    switch (i) {
      case 0: return x;
      case 1: return y;
      default: throw new IllegalArgumentException();
    }
  }

  @Override
  public void setElement(int i, double v) {
    switch (i) {
      case 0: x = v; return;
      case 1: y = v; return;
      default: throw new IllegalArgumentException();
    }
  }
}
