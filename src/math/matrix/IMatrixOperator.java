package math.matrix;

public interface IMatrixOperator<T extends SquareMatrix<?>, R extends IMatrixModifier<T,?>> {
  R plus(T rhs);
  R minus(T rhs);
  R times(double s);
  R divide(double s);
  R dot(T rhs);
  // IVector dot(IVector rhs);
  // R transpose();
  // R invert();
  double det();
}
