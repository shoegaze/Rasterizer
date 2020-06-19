package math.matrix;

import math.vector.Vector3;

public class Matrix3_3 extends SquareMatrix<Vector3> {
  public static final ConstMatrix<Matrix3_3> IDENTITY = new ConstMatrix<>(new Matrix3_3(1, 0, 0,
                                                                                        0, 1, 0,
                                                                                        0, 0, 1));
  public static final ConstMatrix<Matrix3_3> ZERO = new ConstMatrix<>(new Matrix3_3(0, 0, 0,
                                                                                    0, 0, 0,
                                                                                    0, 0, 0));
  public static final ConstMatrix<Matrix3_3> ONES = new ConstMatrix<>(new Matrix3_3(1, 1, 1,
                                                                                    1, 1, 1,
                                                                                    1, 1, 1));


  public Matrix3_3(double a00, double a01, double a02,
                   double a10, double a11, double a12,
                   double a20, double a21, double a22) {

    // Pass columns first in super
    super(a00, a10, a20,
          a01, a11, a21,
          a02, a12, a22);
  }

  public Matrix3_3(Vector3 ai0, Vector3 ai1, Vector3 ai2) {
    this(ai0.getElement(0), ai1.getElement(0), ai2.getElement(0),
         ai0.getElement(1), ai1.getElement(1), ai2.getElement(1),
         ai0.getElement(2), ai1.getElement(2), ai2.getElement(2));
  }

  @Override
  public int getSize() {
    return 3;
  }

  @Override
  public Vector3 getRow(int i) {
    return new Vector3(
      getElement(i, 0),
      getElement(i, 1),
      getElement(i, 2));
  }

  @Override
  public Vector3 getCol(int j) {
    return new Vector3(
      getElement(0, j),
      getElement(1, j),
      getElement(2, j));
  }

  @Override
  public double det() {
    double a00 = getElement(0, 0), a01 = getElement(0, 1), a02 = getElement(0, 2);
    double a10 = getElement(1, 0), a11 = getElement(1, 1), a12 = getElement(1, 2);
    double a20 = getElement(2, 0), a21 = getElement(2, 1), a22 = getElement(2, 2);

    return a00*(a11*a22 - a12*a21) -
           a01*(a10*a22 - a12*a20) +
           a02*(a10*a21 - a11*a20);
  }

  @Override
  public SquareMatrix<Vector3> copy() {
    return new Matrix3_3(
      getCol(0),
      getCol(1),
      getCol(2));
  }
}
