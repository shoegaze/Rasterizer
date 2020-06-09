package math.matrix;

public interface IMatrixOperator<T extends SquareMatrix<?>, R extends IMatrixModifier<T,?>> {
  R plus(T rhs);
  R minus(T rhs);
  R times(double s);
  R divide(double s);
  R dot(T rhs);
  // Vector dot(Vector rhs);
  // R transpose();
  double det();
}
