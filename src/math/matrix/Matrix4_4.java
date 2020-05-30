package math.matrix;

import math.vec.Vector4;

public class Matrix4_4 implements ISquareMatrix<Vector4> {
  private double[] elems;

  public Matrix4_4(double a00, double a01, double a02, double a03,
                   double a10, double a11, double a12, double a13,
                   double a20, double a21, double a22, double a23,
                   double a30, double a31, double a32, double a33) {

    elems = new double[] {a00, a10, a20, a30,
                          a01, a11, a21, a31,
                          a02, a12, a22, a32,
                          a03, a13, a23, a33};
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
  public int index2dTo1d(int i, int j) {
    return 4*j + i;
  }

  @Override
  public double getElement(int i, int j) {
    return elems[index2dTo1d(i, j)];
  }

  @Override
  public void setElement(int i, int j, double value) {
    elems[index2dTo1d(i, j)] = value;
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
    // TODO Auto-generated method stub
    return 0;
  }
}
