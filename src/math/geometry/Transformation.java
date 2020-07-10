package math.geometry;

import math.matrix.Matrix4_4;
import math.matrix.modifier.MutableMatrix;
import math.vector.Vector3;
import math.vector.modifier.NormalVector;

public class Transformation {
  private class Translation {}
  private class Rotation {}
  private class Scaling {}

  private MutableMatrix<Matrix4_4> matrix;

  public Transformation(Transformation transformation) {

  }

  public void translate(Vector3 t) {
    matrix.dotLeft(new Matrix4_4(0, 0, 0, t.x(),
                                 0, 0, 0, t.y(),
                                 0, 0, 0, t.z(),
                                 0, 0, 0, 1));
  }

  public void rotate(NormalVector<Vector3> r, double theta) {
    // https://en.wikipedia.org/wiki/Transformation_matrix#cite_ref-5
    //  Szymanski, John E. (1989). Basic Mathematics for Electronic Engineers:Models and Applications.

    final Vector3 axis = r.getVec();
    final double l = axis.x();
    final double m = axis.y();
    final double n = axis.z();

    final double s = Math.sin(theta);
    final double c = Math.cos(theta);
    final double c_1 = 1 - c;

    matrix.dotLeft(new Matrix4_4(
        l*l*c_1 + c,   m*l*c_1 - n*s, n*l*c_1 + m*s, 0,
        l*m*c_1 + n*s, m*m*c_1 + c,   n*m*c_1 - l*s, 0,
        l*n*c_1 - m*s, m*n*c_1 + l*s, n*n*c_1 + c,   0,
        0,             0,             0,             1));
  }

  public void scale(Vector3 s) {
    matrix.dotLeft(new Matrix4_4(s.x(), 0,     0,     0,
                                 0,     s.y(), 0,     0,
                                 0,     0,     s.z(), 0,
                                 0,     0,     0,     1));
  }
}
