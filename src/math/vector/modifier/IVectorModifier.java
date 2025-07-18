package math.vector.modifier;

import math.vector.IVectorOperator;
import math.vector.Vector;

public interface IVectorModifier<T extends Vector, R extends IVectorModifier<T, ?>>
  extends IVectorOperator<T, R> {

    String toString();
    T getVec();
}
