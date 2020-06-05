package math.matrix;

public class Scaling3D extends Matrix4_4 {
  private double sx;
  private double sy;
  private double sz;

  public Scaling3D(double sx, double sy, double sz) {
    super(sx, 0,  0, 0,
          0, sy,  0, 0,
          0,  0, sz, 0,
          0,  0,  0, 1);

    this.sx = sx;
    this.sy = sy;
    this.sz = sz;
  }

  public Scaling3D(double s) {
    this(s, s, s);
  }

  // public Scaling3D invert() {
  //   return new Scaling3D(1/sx, 1/sy, 1/sz);
  // }
}