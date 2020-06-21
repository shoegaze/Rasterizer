package math.matrix.transform;

import math.matrix.transform.InvertibleMap3D;

public class Transform3D extends InvertibleMap3D {
  // TODO:
  protected Transform3D(double a00, double a01, double a02, double a03, double a10, double a11, double a12, double a13, double a20, double a21, double a22, double a23, double a30, double a31, double a32, double a33) {
    super(a00, a01, a02, a03, a10, a11, a12, a13, a20, a21, a22, a23, a30, a31, a32, a33);
  }

  @Override
  public InvertibleMap3D invert() {
    // TODO Auto-generated method stub
    return null;
  }

}
