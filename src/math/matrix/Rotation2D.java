package math.matrix;

public final class Rotation2D extends Matrix3_3 {
  private double theta;

  public Rotation2D(double theta) {
    super(Math.cos(theta), -Math.sin(theta), 0,
          Math.sin(theta),  Math.cos(theta), 0,
          0,                0,               1);

    this.theta = theta;
  }

  public Rotation2D invert() {
    return new Rotation2D(-theta);
  }
}
