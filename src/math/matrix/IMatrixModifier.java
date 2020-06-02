package math.matrix;

public interface IMatrixModifier<T extends SquareMatrix<?>, R extends IMatrixModifier<T,?>>
  extends IMatrixOperator<T, R> {

    String toString();
    T getMatrix();
}
