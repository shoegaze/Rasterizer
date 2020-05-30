package math.matrix;

import math.vec.Vector2;

public class Matrix2_2 implements ISquareMatrix<Vector2> {
  private double[] elems;

  public Matrix2_2(double a00, double a01,
                   double a10, double a11) {

    elems = new double[]{a00, a01,
                         a10, a11};
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
  public int index2dTo1d(int i, int j) {
    return 2*j + i;
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
    double a = elems[0], b = elems[2];
    double c = elems[1], d = elems[3];

    return a*b - c*d;
  }
}
