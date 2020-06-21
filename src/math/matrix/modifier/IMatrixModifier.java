package math.matrix.modifier;

import math.matrix.IMatrixOperator;
import math.matrix.SquareMatrix;

public interface IMatrixModifier<T extends SquareMatrix<?>, R extends IMatrixModifier<T,?>>
  extends IMatrixOperator<T, R> {

    String toString();
    T getMatrix();
}
