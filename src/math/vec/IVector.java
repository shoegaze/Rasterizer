package math.vec;

public interface IVector {
  boolean equals(IVector rhs, double epsilon);
  String toString();
  IVector copy();

  int getSize();
  double getElement(int i);
  void setElement(int i, double value);
}