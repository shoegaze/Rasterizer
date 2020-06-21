package math.modifier;

import math.matrix.MutableMatrix;
import math.matrix.SquareMatrix;
import math.vec.MutableVector;
import math.vec.Vector;

public final class Mutable {
  public static <V extends Vector> MutableVector<V> of(V vec) {
    return new MutableVector<>(vec);
  }

  public static <M extends SquareMatrix<?>> MutableMatrix<M> of(M mat) {
    return new MutableMatrix<>(mat);
  }

  private Mutable() {}
}
