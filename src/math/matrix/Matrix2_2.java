package math.matrix;

import math.vec.Vector2;

public class Matrix2_2 extends SquareMatrix<Vector2> {
  public static final ConstMatrix<Matrix2_2> IDENTITY = new ConstMatrix<>(new Matrix2_2(1, 0,
                                                                            0, 1));
  public static final ConstMatrix<Matrix2_2> ZERO = new ConstMatrix<>(new Matrix2_2(0, 0,
                                                                        0, 0));
  public static final ConstMatrix<Matrix2_2> ONES = new ConstMatrix<>(new Matrix2_2(1, 1,
                                                                        1, 1));


  public Matrix2_2(double a00, double a01,
                   double a10, double a11) {

    // Pass columns first in super
    super(a00, a10,
          a01, a11);
  }

  public Matrix2_2(Vector2 ai0, Vector2 ai1) {
    this(ai0.getElement(0), ai1.getElement(0),
         ai0.getElement(1), ai1.getElement(1));
  }

  @Override
  public int getSize() {
    return 2;
  }

  @Override
  public Vector2 getRow(int i) {
    return new Vector2(
      getElement(i, 0),
      getElement(i, 1));
  }

  @Override
  public Vector2 getCol(int j) {
    return new Vector2(
      getElement(0, j),
      getElement(1, j));
  }

  @Override
  public double det() {
    double a = getElement(0, 0), b = getElement(0, 1);
    double c = getElement(1, 0), d = getElement(1, 1);

    return a*b - c*d;
  }

  @Override
  public SquareMatrix<Vector2> copy() {
    return new Matrix2_2(
      getCol(0),
      getCol(1));
  }
}
