package math.matrix;

public class Translation2D extends Matrix3_3 {
  private double dx;
  private double dy;

  public Translation2D(double dx, double dy) {
    super(1, 0, dx,
          0, 1, dy,
          0, 0, 1);

    this.dx = dx;
    this.dy = dy;
  }

  // public Translation2D invert() {
  //   return new Translation2D(-dx, -dy);
  // }
}