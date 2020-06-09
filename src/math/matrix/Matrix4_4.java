package math.matrix;

import math.vec.Vector4;

public class Matrix4_4 extends SquareMatrix<Vector4> {
  public static final ConstMatrix<Matrix4_4> IDENTITY = new ConstMatrix<>(new Matrix4_4(1, 0, 0, 0,
                                                                                        0, 1, 0, 0,
                                                                                        0, 0, 1, 0,
                                                                                        0, 0, 0, 1));
  public static final ConstMatrix<Matrix4_4> ZERO = new ConstMatrix<>(new Matrix4_4(0, 0, 0, 0,
                                                                                    0, 0, 0, 0,
                                                                                    0, 0, 0, 0,
                                                                                    0, 0, 0, 0));
  public static final ConstMatrix<Matrix4_4> ONES = new ConstMatrix<>(new Matrix4_4(1, 1, 1, 1,
                                                                                    1, 1, 1, 1,
                                                                                    1, 1, 1, 1,
                                                                                    1, 1, 1, 1));


  public Matrix4_4(double a00, double a01, double a02, double a03,
                   double a10, double a11, double a12, double a13,
                   double a20, double a21, double a22, double a23,
                   double a30, double a31, double a32, double a33) {

    // Pass columns first in super
    super(a00, a10, a20, a30,
          a01, a11, a21, a31,
          a02, a12, a22, a32,
          a03, a13, a23, a33);
  }

  public Matrix4_4(Vector4 ai0, Vector4 ai1, Vector4 ai2, Vector4 ai3) {
    this(
      ai0.getElement(0), ai1.getElement(0), ai2.getElement(0), ai3.getElement(0),
      ai0.getElement(1), ai1.getElement(1), ai2.getElement(1), ai3.getElement(1),
      ai0.getElement(2), ai1.getElement(2), ai2.getElement(2), ai3.getElement(2),
      ai0.getElement(3), ai1.getElement(3), ai2.getElement(3), ai3.getElement(3));
  }

  @Override
  public int getSize() {
    return 4;
  }

  @Override
  public Vector4 getRow(int i) {
    return new Vector4(
      getElement(i, 0),
      getElement(i, 1),
      getElement(i, 2),
      getElement(i, 3));
  }

  @Override
  public Vector4 getCol(int j) {
    return new Vector4(
      getElement(0, j),
      getElement(1, j),
      getElement(2, j),
      getElement(3, j));
  }

  @Override
  public double det() {
    double a00 = getElement(0, 0), a01 = getElement(0, 1), a02 = getElement(0, 2), a03 = getElement(0, 3);
    double a10 = getElement(1, 0), a11 = getElement(1, 1), a12 = getElement(1, 2), a13 = getElement(1, 3);
    double a20 = getElement(2, 0), a21 = getElement(2, 1), a22 = getElement(2, 2), a23 = getElement(2, 3);
    double a30 = getElement(3, 0), a31 = getElement(3, 1), a32 = getElement(3, 2), a33 = getElement(3, 3);

    // wow
    return a00*(new Matrix3_3(a11, a12, a13,
                              a21, a22, a23,
                              a31, a32, a33).det()) -
           a01*(new Matrix3_3(a10, a12, a13,
                              a20, a22, a23,
                              a30, a32, a33).det()) +
           a02*(new Matrix3_3(a10, a11, a13,
                              a20, a21, a23,
                              a30, a31, a33).det()) -
           a03*(new Matrix3_3(a10, a11, a12,
                              a20, a21, a22,
                              a30, a31, a32).det());
  }

  @Override
  public SquareMatrix<Vector4> copy() {
    return new Matrix4_4(
      getRow(0),
      getRow(1),
      getRow(2),
      getRow(3));
  }
}
