package math.matrix;

import math.vec.IVector;

// Column-major square matrix
public interface ISquareMatrix<R extends IVector> {
  ISquareMatrix<R> copy();
  String toString();

  int getSize();
  int index2dTo1d(int i, int j);
  double getElement(int i, int j);
  R getRow(int i);
  R getCol(int j);
  void setElement(int i, int j, double value);
  void setRow(int i, R row);
  void setCol(int j, R col);
  double det();
  // R invert();
  // R transposed();
}
