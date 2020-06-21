package math.matrix.transform;

import math.matrix.Matrix4_4;

public abstract class InvertibleMap3D extends InvertibleMap<Matrix4_4, InvertibleMap3D> {
  protected InvertibleMap3D(double a00, double a01, double a02, double a03,
                            double a10, double a11, double a12, double a13,
                            double a20, double a21, double a22, double a23,
                            double a30, double a31, double a32, double a33) {

    super(new Matrix4_4(a00, a01, a02, a03,
                        a10, a11, a12, a13,
                        a20, a21, a22, a23,
                        a30, a31, a32, a33));
  }
}
