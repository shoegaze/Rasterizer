package math;

import math.matrix.ConstMatrix;
import math.matrix.SquareMatrix;
import math.vector.ConstVector;
import math.vector.Vector;

public final class Const {
  public static <V extends Vector> ConstVector<V> of(V vec) {
    return new ConstVector<>(vec);
  }

  public static <M extends SquareMatrix<?>> ConstMatrix<M> of(M mat) {
    return new ConstMatrix<>(mat);
  }

  private Const() {}
}
