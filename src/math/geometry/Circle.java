package math.geometry;

import math.modifier.Const;
import math.vector.Vector3;
import math.vector.modifier.ConstVector;

public class Circle {
  public ConstVector<Vector3> origin;
  public int radius;

  public Circle(Vector3 origin, int radius) {
    this.origin = Const.of(origin);
    this.radius = radius;
  }
}
