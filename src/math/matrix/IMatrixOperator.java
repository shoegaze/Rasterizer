package math.matrix;

public interface IMatrixOperator<T extends ISquareMatrix<?>, R extends IMatrixModifier<T,?>> {
  R plus(T rhs);
  R minus(T rhs);
  R times(double s);
  R divide(double s);
  R dot(T rhs);
  R invert();
  double det();
}
