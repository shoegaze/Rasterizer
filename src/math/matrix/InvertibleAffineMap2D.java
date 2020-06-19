package math.matrix;

public abstract class InvertibleAffineMap2D extends InvertibleAffineMap<Matrix3_3, InvertibleAffineMap2D> {
  protected InvertibleAffineMap2D(double a00, double a01, double a02,
                                  double a10, double a11, double a12,
                                  double a20, double a21, double a22) {

    super(new Matrix3_3(a00, a01, a02,
                        a10, a11, a12,
                        a20, a21, a22));
  }
}
