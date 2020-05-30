package math.matrix;

import math.vec.IVector;

// Column-major square matrix
public interface ISquareMatrix<R extends IVector> {
  ISquareMatrix<R> copy();
  String toString();

  int getSize();
  int index2dTo1d(int i, int j);
  double getElement(int i, int j);
  void setElement(int i, int j, double value);
  R getRow(int i);
  R getCol(int j);
  double det();
  // R invert();
}
