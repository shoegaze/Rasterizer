package math.vec;

public interface IVectorOperator<T extends Vector, R extends IVectorModifier<T,?>> {
  boolean equals(T rhs, double epsilon);
  boolean equals(R rhs, double epsilon);
  R plus(T rhs);
  R plus(R rhs);
  R minus(T rhs);
  R minus(R rhs);
  R times(double s);
  R divide(double s);
  R negate();
  double dot(T rhs);
  double dot(R rhs);
  double magnitude_2();
  double magnitude();
  NormalVector<T> normalized();
  R cross(Vector3 rhs);
  R cross(IVectorModifier<Vector3,?> rhs);
}
