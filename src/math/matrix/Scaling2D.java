package math.matrix;

public class Scaling2D extends Matrix3_3 {
  private double sx;
  private double sy;

  public Scaling2D(double sx, double sy) {
    super(sx, 0, 0,
          0, sy, 0,
          0,  0, 1);

    this.sx = sx;
    this.sy = sy;
  }

  public Scaling2D(double s) {
    this(s, s);
  }

  // public Scaling2D invert() {
  //   return new Scaling2D(1/sx, 1/sy);
  // }
}