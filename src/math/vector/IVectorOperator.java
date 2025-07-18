package math.vector;

import math.vector.modifier.IVectorModifier;
import math.vector.modifier.NormalVector;

public interface IVectorOperator<T extends Vector, R extends IVectorModifier<T, ?>> {
  boolean equals(T rhs, double epsilon);
  // TODO: (R rhs) -> (IVectorModifier<T, ?> rhs)
  boolean equals(R rhs, double epsilon);
  R plus(T rhs);
  // TODO: (R rhs) -> (IVectorModifier<T, ?> rhs)
  R plus(R rhs);
  R minus(T rhs);
  // TODO: (R rhs) -> (IVectorModifier<T, ?> rhs)
  R minus(R rhs);
  R times(double s);
  R divide(double s);
  R negate();
  double dot(T rhs);
  // TODO: (R rhs) -> (IVectorModifier<T, ?> rhs)
  double dot(R rhs);
  double length_2();
  double length();
  NormalVector<T> normalized();
  R cross(Vector3 rhs);
  R cross(IVectorModifier<Vector3, ?> rhs);
}
