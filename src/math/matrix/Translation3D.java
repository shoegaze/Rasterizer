package math.matrix;

public class Translation3D extends Matrix4_4 {
  private double dx;
  private double dy;
  private double dz;

  public Translation3D(double dx, double dy, double dz) {
    super(1, 0, 0, dx,
          0, 1, 0, dy,
          0, 0, 1, dz,
          0, 0, 0,  1);

    this.dx = dx;
    this.dy = dy;
    this.dz = dz;
  }

  // public Translation3D invert() {
  //   return new Translation3D(-dx, -dy, -dz);
  // }
}