package math.vec;

public interface IVectorOperator<T extends Vector, R extends IVectorModifier<T,?>> {
  boolean equals(T rhs, double epsilon);
  R plus(T rhs);
  R minus(T rhs);
  R times(double s);
  R divide(double s);
  R negate();
  double dot(T rhs);
  double magnitude_2();
  double magnitude();
  NormalVector<T> normalized();
  R cross(Vector3 rhs);
}