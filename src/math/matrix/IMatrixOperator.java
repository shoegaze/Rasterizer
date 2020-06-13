package math.matrix;

public interface IMatrixOperator<T extends SquareMatrix<?>, R extends IMatrixModifier<T,?>> {
  boolean equals(T rhs, double epsilon);
  boolean equals(R rhs, double epsilon);
  R plus(T rhs);
  R plus(R rhs);
  R minus(T rhs);
  R minus(R rhs);
  R times(double s);
  R divide(double s);
  R dot(T rhs);
  R dot(R rhs);
  R transpose();
  double det();
}
