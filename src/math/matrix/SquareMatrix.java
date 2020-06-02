package math.matrix;

import java.util.Arrays;
import math.vec.Vector;

// Column-major square matrix
public abstract class SquareMatrix<R extends Vector> {
  private double[] elements;
  private boolean transposed = false;

  protected SquareMatrix(double ...elements) {
    // TODO: check if there are n^2 elements in array
    this.elements = elements.clone();
  }

  public abstract SquareMatrix<R> copy();
  public abstract int getSize();
  public abstract R getRow(int i);
  public abstract R getCol(int j);
  public abstract double det();
  // public abstract R invert();

  public final boolean equals(SquareMatrix<?> rhs, double epsilon) {
    if (this.getClass() != rhs.getClass()) {
      return false;
    }

    for (int i = 0; i < getSize(); ++i) {
      if (!this.getRow(i).equals(rhs.getRow(i), epsilon)) {
        return false;
      }
    }

    return true;
  }

  public final String toString() {
    String[] cols = new String[getSize()];

    for (int j = 0; j < getSize(); ++j) {
      cols[j] = getCol(j).toString();
    }

    return Arrays.toString(cols);
  }

  protected final int index2dTo1d(int i, int j) {
    return transposed?
      getSize()*i + j :
      getSize()*j + i;
  }

  public final double getElement(int i, int j) {
    return elements[index2dTo1d(i, j)];
  }

  public final void setElement(int i, int j, double value) {
    elements[index2dTo1d(i, j)] = value;
  }

  public final void setRow(int i, R row) {
    for (int j = 0; j < getSize(); ++j) {
      setElement(i, j, row.getElement(j));
    }
  }

  public final void setCol(int j, R col) {
    for (int i = 0; i < getSize(); ++i) {
      setElement(i, j, col.getElement(i));
    }
  }

  public final void transpose() {
    transposed = !transposed;
  }
}
