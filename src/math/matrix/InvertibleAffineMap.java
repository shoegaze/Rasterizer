package math.matrix;

import math.vector.ConstVector;
import math.vector.Vector;

public abstract class InvertibleAffineMap<T extends SquareMatrix<?>, R extends InvertibleAffineMap<?,?>> {
  private T mat;

  protected InvertibleAffineMap(T src) {
    mat = src;
  }

  public abstract R invert();

  @SuppressWarnings("unchecked")
  public <V extends Vector> V dot(V rhs) {
    // HACK
    if (mat.getSize() != rhs.getSize()) {
      throw new IllegalArgumentException();
    }

    V result = (V)rhs.copy();

    for (int i = 0; i < mat.getSize(); ++i) {
      ConstVector<V> row = new ConstVector<>((V)mat.getRow(i));
      result.setElement(i, row.dot(rhs));
    }

    return result;
  }
}