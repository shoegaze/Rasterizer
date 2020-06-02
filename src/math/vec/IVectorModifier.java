package math.vec;

// TODO: Convert to abstract class?
public interface IVectorModifier<T extends Vector, R extends IVectorModifier<T, ?>>
  extends IVectorOperator<T, R> {

    String toString();
    T getVec();
}