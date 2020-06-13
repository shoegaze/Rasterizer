package math.vec;

public interface IVectorModifier<T extends Vector, R extends IVectorModifier<T, ?>>
  extends IVectorOperator<T, R> {

    String toString();
    T getVec();
}
