package math.vec;

// TODO: Convert to abstract class?
public interface IVectorModifier<T extends IVector, R extends IVectorModifier<T,?>>
  extends IVectorOperator<T, R> {

    T getVec();
}