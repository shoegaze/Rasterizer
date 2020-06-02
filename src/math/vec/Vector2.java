package math.vec;

public final class Vector2 extends Vector {
  public static final ConstVector<Vector2> ZERO = new ConstVector<>(new Vector2(0, 0));
  public static final ConstVector<Vector2> ONES = new ConstVector<>(new Vector2(1, 1));
  public static final ConstVector<Vector2> RIGHT = new ConstVector<>(new Vector2(1, 0));
  public static final ConstVector<Vector2> LEFT = new ConstVector<>(new Vector2(-1, 0));
  public static final ConstVector<Vector2> UP = new ConstVector<>(new Vector2(0, 1));
  public static final ConstVector<Vector2> DOWN = new ConstVector<>(new Vector2(0, -1));


  public Vector2(double x, double y) {
    super(x, y);
  }

  public double x() {
    return getElement(0);
  }

  public double y() {
    return getElement(1);
  }

  @Override
  public Vector2 copy() {
    return new Vector2(
      getElement(0),
      getElement(1));
  }

  @Override
  public int getSize() {
    return 2;
  }
}
