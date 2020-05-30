package math.matrix;

public interface IMatrixModifier<T extends ISquareMatrix<?>, R extends IMatrixModifier<T,?>> extends IMatrixOperator<T, R> {
  T getMatrix();
}
